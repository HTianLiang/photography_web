package com.tl.photo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tl.photo.config.RespBean;
import com.tl.photo.config.VerifyCode;
import com.tl.photo.domain.Users;
import com.tl.photo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author tl
 * @Date 2022/1/21 12:03 上午
 * @Version 1.0
 * @Description
 */
@RestController
public class WebLoginController {
    @Autowired
    private UsersService usersService;

    // 存储验证码
    private String verify_Code;
    public void code(String verifyCode){
        this.verify_Code = verifyCode;
    }

    /**
     * 前台登录验证码
     * @param session
     * @param response
     * @throws IOException
     */
    @GetMapping("/verifyCode")
    public void verify(HttpSession session, HttpServletResponse response) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        String text = verifyCode.getText();
        code(text);
        session.setAttribute("verify_code",text);
        VerifyCode.output(image,response.getOutputStream());
    }

    /**
     * 前台登录验证
     * @param session
     * @param response
     * @param users
     * @throws IOException
     */
    @RequestMapping("/webLogin")
    public void login(HttpSession session,HttpServletResponse response, @RequestBody Users users) throws IOException {
        System.out.println(users.getUsername());
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 1.先判断验证码是否正确
        System.out.println("验证码 "+verify_Code+" 输入的验证码 "+users.getVerifyCode());
        String inputCode = users.getVerifyCode();
        // equalsIgnoreCase 比较时忽略大小写
        if (verify_Code.equalsIgnoreCase(inputCode)) {
            Users user = usersService.findByUsernameAndPassword(users.getUsername(), users.getPassword());
            // 2.再判断用户信息是否正确
            if (user == null) {
                out.write(new ObjectMapper().writeValueAsString(RespBean.error("用户名或密码错误")));
            } else {
                // 3.若用户信息正确，则传递登录成功状态到前端
                out.write(new ObjectMapper().writeValueAsString(RespBean.ok("登录成功")));
            }
        }else {
            //验证码不正确
            out.write(new ObjectMapper().writeValueAsString(RespBean.error("验证码不正确")));
        }
        out.flush();
        out.close();
    }

}

package com.tl.demo;

/**
 * @Author tl
 * @Date 2021/11/15 7:41 下午
 * @Version 1.0
 * @Description
 */
public enum EnumTest {
    BLUE(1,"蓝色"),RED(2,"红色");

    private int type;
    private String desc;

    EnumTest(int type, String s) {
        this.type = type;
        this.desc = s;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

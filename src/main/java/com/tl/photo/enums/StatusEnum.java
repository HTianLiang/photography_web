package com.tl.photo.enums;

/**
 * @Author tl
 * @Date 2021/11/15 8:15 下午
 * @Version 1.0
 * @Description 当前状态枚举类
 */
public enum StatusEnum {
    STATUS_OF_NO(-1,"未审核"), STATUS_OF_CLOSE(0,"未启用"), STATUS_OF_USE(1,"已启用");

    private int type;
    private String desc;

    StatusEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
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

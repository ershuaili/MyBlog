package com.myblog.security.resp;

/**
 * <p>描述: [统一返回码] </p>
 * <p>创建时间: 2021/11/08 下午 11:16 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
public enum ResponseStatusCode {

    /**
     * 统一返回码
     */
    SUCCESS(200, "请求成功"),
    ERROR(500, "服务器异常"),
    URL_ERROR(404, "路径有误"),
    LOGIN_FAILED(10000, "登录失败"),
    NO_AUTHORITY(10010, "无权限");
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应结果描述
     */
    private String desc;

    ResponseStatusCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

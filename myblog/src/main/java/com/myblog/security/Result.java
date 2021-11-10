package com.myblog.security;

/**
 * <p>描述: [响应码] </p>
 * <p>创建时间: 2021/11/09 下午 05:58 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
public class Result {
    private int code;
    public Result(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
}
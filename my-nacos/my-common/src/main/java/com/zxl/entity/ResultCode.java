package com.zxl.entity;


/**
 *  <p> 响应码枚举 - 可参考HTTP状态码的语义 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/8/22 11:09
 */
public enum ResultCode {
    //成功
    SUCCESS( 200, "SUCCESS" ),
    //失败
    FAILURE( 400, "FAILURE" ),
    // 未登录
    UN_LOGIN( 401, "未登录" ),
    //未认证（签名错误、token错误）
    UNAUTHORIZED( 403, "未认证或Token失效" ),
    //未通过认证
    USER_UNAUTHORIZED( 402, "用户名或密码不正确" ),
    //接口不存在
    NOT_FOUND( 404, "接口不存在" ),
    //服务器内部错误
    INTERNAL_SERVER_ERROR( 500, "服务器内部错误" ),

    /**
     * 登录
     */
    ACCOUNT_IS_EMPTY(10001, "账号不能为空"),
    ACCOUNT_OR_PASSWORD_ERROR(10002, "账号或密码错误"),
    ACCOUNT_NAME_EXITS(10003, "账号已存在"),
    ACCOUNT_DISABLED(10004, "账号已禁用"),
    USER_INFO_NOT_EXIST(10005, "用户信息不存在"),
    USER_INFO_UPDATE_FAIL(10006, "更新用户信息失败"),
    USER_INFO_SAVE_FAIL(10007, "保存用户信息失败"),

    PHONE_NUMBER_IS_EMPTY(10102, "手机号不能为空"),
    PHONE_IS_EXITS_BIND(10103, "手机号已绑定"),
    PHONE_EXITS_WITH_CURRENT(10104, "手机号与当前一致"),
    PHONE_RESET_FAIL(10105, "变更手机号码失败"),
    PHONE_EXITS(10106, "手机号已存在"),
    PHONE_NOT_EXITS(10107, "手机号不存在"),

    PASSWORD_IS_EMPTY(10201, "密码不能为空"),
    PASSWORD_ERROR(10202, "两次密码不一致"),

    SMS_CODE_ERROR(10301, "验证码不正确"),
    SMS_CODE_COUNT(10302, "验证码超过发送次数"),
    SMS_TYPE_ERROR(10303, "短信类型不正确"),
    SMS_CODE_IS_EMPTY(10304, "验证码不能为空"),

    LOGIN_FAIL(20001, "登录失败"),
    NOT_LOGIN(20002, "未登录，请先登录"),
    LOGIN_METHOD_IS_EMPTY(20004, "登录方式不能为空"),
    AUTH_SERVER_ERROR(20005, "授权服务异常"),

    REGISTER_SUCCESS(20101, "注册成功"),
    REGISTER_FAIL(20102, "注册失败"),

    /**
     * 文件上传
     */
    FILE_NOT_EMPTY(30001, "文件不能为空"),
    FILE_NOT_SUPPORT(30002, "文件不支持"),
    FILE_TOO_LARGE(30003, "文件太大"),
    FILE_LEGITIMATE_ERROR(30004, "文件不合法"),
    FILE_UPLOAD_ERROR(30005, "文件上传失败"),

    UPLOAD_ATTACHMENT_SIZE_ERROR(30100, "上传的文件超过6个"),
    UPLOAD_ATTACHMENT_RECORD_NOT_EXIST(30101, "文件记录不存在"),

    /**
     * Excel 导出失败
     */
    EXCEL_IMPORT_FAIL(40001, "excel 导入失败"),
    EXCEL_EXPORT_FAIL(40002, "excel 导出失败"),

    /**
     * permission
     */
    PERMISSION_ACCESS_DENIED(50001, "permission access denied"),

    /**
     * 操作频繁
     */
    OPERATION_LIMIT_FAIL(50101, "访问频繁，请稍后再试"),

    /**
     * 参数校验
     */
    PARAMS_VALIDATE_FAIL(-10000, "参数校验失败"),

    /**
     * token
     */
    TOKEN_IS_EMPTY(-10101, "token must not be null"),
    TOKEN_VALIDATE_FAIL(-10102, "token check fail"),
    TOKEN_INVALID(-10103, "invalid access token"),
    REFRESH_TOKEN_NOT_EXIST(-10104, "refresh token not exist"),
    ACCESS_TOKEN_IS_EMPTY(-10105, "access token is empty"),

    /**
     * 未知错误
     */
    UN_KNOWN_ERROR(-1, "未知错误")
    ;


    private int code;
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

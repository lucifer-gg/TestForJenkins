package oasis.vo;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/06 07:47
 * @description 状态码的枚举
 */
public final class ResponseStatus {

    public static final ResponseStatus STATUS_SUCCESS = new ResponseStatus("0000", "Success");
    public static final ResponseStatus SERVER_ERROR = new ResponseStatus("0001", "Server error");
    public static final ResponseStatus STATUS_NOT_AUTHORIZED = new ResponseStatus("0002", "没有权限");

    public String code;

    public String msg;

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    private ResponseStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
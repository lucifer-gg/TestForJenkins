package oasis.vo;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/03/06 07:48
 * @description 自定义状态码
 */
public class BasicResponse<T> {

    ResponseStatus status;

    T data;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public BasicResponse(ResponseStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public BasicResponse(ResponseStatus status) {
        this(status, null);
    }
}

//package stuff.mall.common;
//
//import java.io.Serializable;
//
//public class ServerResponse implements Serializable {
//    private int status;
//    private String msg;
//    private T date;
//
//    private ServerResponse(int status){
//        this.status = status;
//    }
//
//    private ServerResponse(int status,T data){
//        this.status = status;
//        this.data = data;
//    }
//
//    public ServerResponse(int status, String msg, T date) {
//        this.status = status;
//        this.msg = msg;
//        this.date = date;
//    }
//
//    @JsonIgnore
//    public boolean isSuccess(){
//        return this.status==ResponseCode.SUCCESS.getCode
//    }
//}

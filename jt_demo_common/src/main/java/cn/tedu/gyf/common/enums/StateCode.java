package cn.tedu.gyf.common.enums;

/**
 * @Date 2020/8/4 10:37
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
public enum StateCode {

    SUCCESS(200,"业务执行成功"),

    FAILED(201,"业务执行失败");

    private int code;
    private String message;

    private StateCode(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode(){
        return this.code;
    }

    public  String getMessage(){
        return this.message;
    }
}

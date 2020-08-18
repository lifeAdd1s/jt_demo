package cn.tedu.gyf.common.vo;

import cn.tedu.gyf.common.enums.StateCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Date 2020/8/4 10:34
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 *
 * 1.设置自定义状态码
 * 2.返回提示信息
 * 3.定义返回对象，如果有返回数据的话
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysResult {

    //表示是否执行成功
    private Integer status;

    //返回提示信息
    private String message;

    //返回数据
    private Object data;


    public static SysResult failed(){
        return new SysResult(StateCode.FAILED.getCode(),StateCode.FAILED.getMessage(),null);
    }

    public static SysResult success(){
        return new SysResult(StateCode.SUCCESS.getCode(),StateCode.SUCCESS.getMessage(),null);
    }

    public  static  SysResult succeess(Object data){
        return new SysResult(StateCode.SUCCESS.getCode(),StateCode.SUCCESS.getMessage(),data);
    }

    public static SysResult success(Object data,String message){
        return new SysResult(StateCode.SUCCESS.getCode(),message,data);
    }
}

package cn.tedu.gyf.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Date 2020/8/12 17:37
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
public class  ObjectMapperUtil  {

    private static  final ObjectMapper MAPPER=new ObjectMapper();

    public static String toJSON(Object object){
        if(object==null)
            throw new RuntimeException("对象不能为空");
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T fromJSON(String jsonString,Class<T> targetObject){
        if(jsonString==null||"".equals(jsonString)||targetObject==null)
            throw new RuntimeException("非法参数");
        try{
            T t=MAPPER.readValue(jsonString,targetObject);
            return t;
        }catch (JsonProcessingException e){
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }
    }
}

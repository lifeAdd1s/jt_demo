package cn.tedu.gyf;

import cn.tedu.gyf.common.pojo.Item;
import cn.tedu.gyf.common.pojo.ItemDesc;
import cn.tedu.gyf.common.util.ObjectMapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * @Date 2020/8/12 16:47
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
public class ObjectMapperTest {

    private static final ObjectMapper MAPPER=new ObjectMapper();

    @Test
    public void objectMapperTest() throws JsonProcessingException {
        ItemDesc itemDesc=new ItemDesc();
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDesc.setItemDesc("测试JSON==对象转换");
        String itemString=ObjectMapperUtil.toJSON(itemDesc);
        ItemDesc res= ObjectMapperUtil.fromJSON(itemString,ItemDesc.class);
        System.out.println(res.toString());
        System.out.println(res.getCreated());
        System.out.println(itemString);
    }

    @Test
    public void testEmail(){


        while(true){
            String emailAddr= new Scanner(System.in).nextLine();
            String[] res=emailAddr.split("@");
            if(emailAddr.length()>16||emailAddr.length()<6)
                continue;
            if(res.length!=2)
                continue;
            if(res[1]!="163.com"||res[1]!="tedu.cn")
                continue;

            String prefix=res[0];
            int length=prefix.length();
            int count_num=0;
            int count_low=0;
            int count_up=0;
            boolean flag_num=true;
            int i=0;
            for(i=0;i<length;i++){
                int character=prefix.charAt(i);
                if(character>=48&&character<=57)
                    count_num++;
                else if(character>=65&&character<=90)
                    count_up++;
                else if (character>=97&&character<=122)
                    count_low++;
                else
                    break;
            }
            if(i!=length-1)
                continue;
            if(count_low!=length&&count_num!=length&&count_up!=length){
                System.out.println(emailAddr);
                break;
            }


        }



    }
}

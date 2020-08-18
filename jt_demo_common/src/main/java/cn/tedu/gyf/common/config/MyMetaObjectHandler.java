package cn.tedu.gyf.common.config;

import cn.tedu.gyf.common.enums.ItemField;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Date 2020/8/4 19:47
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName(ItemField.CREATED.getName(),new Date(System.currentTimeMillis()),metaObject);
        this.setFieldValByName(ItemField.UPDATE.getName(),new Date(System.currentTimeMillis()),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName(ItemField.UPDATE.getName(),new Date(System.currentTimeMillis()),metaObject);
    }
}

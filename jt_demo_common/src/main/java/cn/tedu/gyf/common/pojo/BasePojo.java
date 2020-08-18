package cn.tedu.gyf.common.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date 2020/8/4 19:35
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Data
public class BasePojo implements Serializable {

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date created;
    /**
     * 更新时间
     */
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date updated;

}

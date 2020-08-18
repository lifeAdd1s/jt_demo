package cn.tedu.gyf.common.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Date 2020/8/5 14:09
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("tb_item_desc")
public class ItemDesc extends BasePojo {
    private static final long serialVersionUID = 4312341308113743693L;

    @TableId
    private Long itemId;
    private String itemDesc;
}

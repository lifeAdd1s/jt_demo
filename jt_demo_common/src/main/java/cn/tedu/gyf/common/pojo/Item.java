package cn.tedu.gyf.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品表(TbItem)实体类
 *
 * @author makejava
 * @since 2020-08-04 19:33:13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Data
@TableName(value = "tb_item")
public class Item extends BasePojo {
    private static final long serialVersionUID = -47627972112519950L;
    /**
     * 商品id，同时也是商品编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品卖点
     */
    private String sellPoint;
    /**
     * 商品价格，单位为：分
     */
    private Long price;
    /**
     * 库存数量
     */
    private Integer num;
    /**
     * 商品条形码
     */
    private String barcode;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 所属类目，叶子类目
     */
    private Long cid;
    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    private Integer status;
//    /**
//     * 创建时间
//     */
//    private Date created;
//    /**
//     * 更新时间
//     */
//    private Date updated;

    public String[] getImages(){
        return this.image.split(",");
    }


}
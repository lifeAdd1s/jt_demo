package cn.tedu.gyf.common.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品类目(TbItemCat)实体类
 *
 * @author makejava
 * @since 2020-08-03 10:29:16
 */
@Data
@TableName("tb_item_cat")
public class ItemCat implements Serializable {
    private static final long serialVersionUID = 132352146966287716L;
    /**
     * 类目ID
     */
    private Long id;
    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private Long parentId;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 状态。可选值:1(正常),2(删除)
     */
    private Integer status;
    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    private Integer sortOrder;
    /**
     * 该类目是否为父类目，1为true，0为false
     */
    private Boolean isParent;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 创建时间
     */
    private Date updated;


}
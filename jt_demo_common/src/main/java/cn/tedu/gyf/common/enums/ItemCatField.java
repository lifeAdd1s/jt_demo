package cn.tedu.gyf.common.enums;

/**
 * @Date 2020/8/6 18:21
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
public enum ItemCatField {


    ID("id"),
    PARENT_ID("parent_id"),
    NAME("name"),
    STATUS("status");



    private String name;
    private ItemCatField(String name){
        this.name=name;
    }


}

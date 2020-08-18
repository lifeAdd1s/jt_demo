package cn.tedu.gyf.common.enums;

/**
 * @Date 2020/7/31 15:47
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
public enum ItemField {

    ID("id"),
    TITLE("title"),
    SELL_POINT("sell_point"),
    PRICE("price"),
    NUM("num"),
    BARCODE("barcode"),
    IMAGE("image"),
    CID("cid"),
    STATUS("status"),
    CREATED("created"),
    UPDATE("updated");

    private  String fieldname;

    private ItemField(String fieldname){
        this.fieldname=fieldname;
    }

    public String getName(){
        return this.fieldname;
    }


}

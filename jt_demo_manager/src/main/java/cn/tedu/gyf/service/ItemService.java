package cn.tedu.gyf.service;

import cn.tedu.gyf.common.pojo.Item;
import cn.tedu.gyf.common.pojo.ItemDesc;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Date 2020/7/31 14:16
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
public interface ItemService  {

    IPage<Item> findItemByLimit(Integer startIndex, Integer pageSize);

    Integer findItemCount();

    void saveItem(Item item, ItemDesc itemDesc);

    void updateItem(Item item);

    ItemDesc findItemDescById(Long itemId);

    void updateItemStatus(Long[] ids,Integer status);
}

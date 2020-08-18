package cn.tedu.gyf.service.impl;

import cn.tedu.gyf.common.anno.CacheFind;
import cn.tedu.gyf.common.enums.ItemField;
import cn.tedu.gyf.common.pojo.Item;
import cn.tedu.gyf.common.pojo.ItemDesc;
import cn.tedu.gyf.dao.ItemDao;
import cn.tedu.gyf.dao.ItemDescDao;
import cn.tedu.gyf.service.ItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @Date 2020/7/31 14:16
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemDao itemDao;
    @Resource
    private ItemDescDao itemDescDao;


    @Override
    public IPage<Item> findItemByLimit(Integer startIndex,Integer pageSize) {

        QueryWrapper condition=new QueryWrapper();
        condition.orderByDesc(ItemField.UPDATE.getName());
        IPage<Item> itemIPage=new Page<>(startIndex,pageSize);
        itemDao.selectPage(itemIPage,condition);

        return itemIPage;
    }

    @Override
    public Integer findItemCount() {
        return itemDao.selectCount(null);
    }

    @Override
    public void saveItem(Item item, ItemDesc itemDesc) {
        Integer line=itemDao.insert(item);
        itemDesc.setItemId(item.getId());
        itemDescDao.insert(itemDesc);
    }

    @Override
    public void updateItem(Item item) {
        itemDao.updateById(item);
    }

    @Override
    public ItemDesc findItemDescById(Long itemId){
        return itemDescDao.selectById(itemId);
    }

    @Override
    public void updateItemStatus(Long[] ids,Integer status) {
        Item item=new Item();
        item.setStatus(status);
        UpdateWrapper<Item> condition=new UpdateWrapper<>();
        condition.in(ItemField.ID.getName(), Arrays.asList(ids));
        itemDao.update(item,condition);
    }


}

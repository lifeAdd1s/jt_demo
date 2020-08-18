package cn.tedu.gyf.controller;

import cn.tedu.gyf.common.pojo.Item;
import cn.tedu.gyf.common.pojo.ItemDesc;
import cn.tedu.gyf.common.vo.EasyUITable;
import cn.tedu.gyf.common.vo.SysResult;
import cn.tedu.gyf.service.ItemService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/7/31 14:10
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@RestController
@RequestMapping("/item/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("query")
    public EasyUITable queryItem(Integer page,Integer rows){


       IPage<Item> itemIPage=itemService.findItemByLimit(page,rows);

       EasyUITable<Item> easyUITable=new EasyUITable<>();
       easyUITable.setTotal(itemIPage.getTotal());
       easyUITable.setRows(itemIPage.getRecords());

       return easyUITable;
    }


    @RequestMapping("save")
    @Transactional
    public SysResult saveItem(Item item, ItemDesc itemDesc){

        item.setStatus(1);
        itemService.saveItem(item,itemDesc);
        System.out.println(item.getId());
        return SysResult.success();
    }

    @RequestMapping("update")
    public SysResult updateItem(Item item){
//        item.setUpdated(new Date(System.currentTimeMillis()));
        itemService.updateItem(item);
        return SysResult.success();
    }

    @RequestMapping("query/item/desc/{itemId}")
    public SysResult queryItemDesc(@PathVariable Long itemId){
        System.out.println(itemId);
        ItemDesc itemDesc=itemService.findItemDescById(itemId);
        return SysResult.succeess(itemDesc);
    }

    @RequestMapping("instock")
    public SysResult instockItem(Long[] ids){
        itemService.updateItemStatus(ids,2);
        return SysResult.success();
    }

    @RequestMapping("reshelf")
    public SysResult reshelfItem(Long[] ids){
        itemService.updateItemStatus(ids,1);
        return SysResult.success();
    }
}

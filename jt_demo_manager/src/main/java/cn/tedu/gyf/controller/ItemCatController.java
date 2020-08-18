package cn.tedu.gyf.controller;

import cn.tedu.gyf.common.vo.EasyUITree;
import cn.tedu.gyf.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date 2020/8/3 10:36
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@RestController
@RequestMapping("/item/cat/")
public class ItemCatController {

    @Resource
    private ItemCatService itemCatService;


    @RequestMapping("queryItemName")
    public String queryItemName(Integer itemCatId){
        return itemCatService.findItemCatById(itemCatId).getName();
    }

    @RequestMapping("list")
    public List<EasyUITree> getItemCatsTree(Long id){
        if(id==null)
            id=0l;
        //itemCatService.findItemCatCache(id);
        return itemCatService.findItemCatListByParentId(id);
    }
}

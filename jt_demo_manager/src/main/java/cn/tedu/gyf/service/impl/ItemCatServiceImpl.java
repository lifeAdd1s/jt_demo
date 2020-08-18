package cn.tedu.gyf.service.impl;

import cn.tedu.gyf.common.anno.CacheFind;
import cn.tedu.gyf.common.pojo.ItemCat;
import cn.tedu.gyf.common.util.ObjectMapperUtil;
import cn.tedu.gyf.common.vo.EasyUITree;
import cn.tedu.gyf.dao.ItemCatDao;
import cn.tedu.gyf.service.ItemCatService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/8/3 10:32
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private ItemCatDao itemCatDao;

    @Autowired(required = false)
    private Jedis jedis;

    @Override
    public ItemCat findItemCatById(Integer itemCatId) {
        return   itemCatDao.selectById(itemCatId);

    }

    @Override
    @CacheFind(key = "ITEM_CAT_LIST")
    public List<EasyUITree> findItemCatListByParentId(Long parentId) {
        QueryWrapper<ItemCat> condition=new QueryWrapper<>();
        condition.eq("parent_id",parentId);
        List<ItemCat> itemCats=itemCatDao.selectList(condition);
        List<EasyUITree> easyUITrees=new ArrayList<>();
        for (ItemCat itemCat : itemCats) {
            Long id=itemCat.getId();
            String text=itemCat.getName();
            String state=itemCat.getIsParent()?"closed":"open";
            EasyUITree easyUITree=new EasyUITree(id,text,state);
            easyUITrees.add(easyUITree);
        }

        return easyUITrees;
    }

    @Override
    public List<EasyUITree> findItemCatCache(Long id) {
        String key="ITEM_CAT_LIST::"+id;
        List<EasyUITree> treeList = new ArrayList<>();


        if(jedis.exists(key)){
            System.out.println(jedis.get(key));
            System.out.println(treeList.getClass());
            treeList=ObjectMapperUtil.fromJSON(jedis.get(key),treeList.getClass());
        }else {
            treeList=findItemCatListByParentId(id);
            jedis.set(key, ObjectMapperUtil.toJSON(treeList));
        }


        return treeList;
    }
}

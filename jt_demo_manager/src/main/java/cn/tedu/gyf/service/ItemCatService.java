package cn.tedu.gyf.service;

import cn.tedu.gyf.common.pojo.ItemCat;
import cn.tedu.gyf.common.vo.EasyUITree;

import java.util.List;

/**
 * @Date 2020/8/3 10:30
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
public interface ItemCatService {

    ItemCat findItemCatById(Integer itemCatId);

    List<EasyUITree> findItemCatListByParentId(Long parentId);

    List<EasyUITree> findItemCatCache(Long id);
}

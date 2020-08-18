package cn.tedu.gyf.service.impl;

import cn.tedu.gyf.common.pojo.User;
import cn.tedu.gyf.dao.UserDao;
import cn.tedu.gyf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date 2020/7/30 19:08
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public List<User> findAll() {
        return userDao.selectList(null);
    }
}

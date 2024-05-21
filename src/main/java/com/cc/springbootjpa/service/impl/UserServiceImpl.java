package com.cc.springbootjpa.service.impl;

import com.cc.springbootjpa.dao.UserDao;
import com.cc.springbootjpa.pojo.User;
import com.cc.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/8
 * Time: 18:28
 * Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll(Integer no, Integer size) {
        // 分页器：no: 当前页索引 size: 每页条数
        Pageable pageable = PageRequest.of(no, size);
        Page<User> page = userDao.findAll(pageable);
        return page.getContent();
    }

}

package com.cc.springbootjpa.service;

import com.cc.springbootjpa.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/8
 * Time: 18:25
 * Description:
 */
public interface UserService {

    List<User> findAll(Integer no, Integer size);

}

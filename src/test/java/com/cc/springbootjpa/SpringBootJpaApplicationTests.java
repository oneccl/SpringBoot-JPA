package com.cc.springbootjpa;

import com.cc.springbootjpa.dao.UserDao;
import com.cc.springbootjpa.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringBootJpaApplicationTests {

    @Autowired
    UserDao userDao;

    // 添加
    // 如果需要添加列字段，在实体类中添加对应字段，Spring Data JPA执行时会自动添加该列
    @Test
    void insert(){
        User user = new User(null, "bb", "234", "女", 18);
        userDao.save(user);
    }
    // 删除
    @Test
    void delete(){
        userDao.deleteById(2);
    }
    // 根据id查找
    @Test
    void queryById(){
        User user = userDao.findById(1).get();
        System.out.println(user);
    }
    // 修改
    @Test
    void update(){
        // 当id重复时，进行修改操作
        User user = new User(1, "aa", "666", "女", 21);
        userDao.save(user);
    }
    // 根据用户名查询
    @Test
    void getUsersByName(){
        // 基于方法名称命名规则查询
        User user = userDao.getByUserName("aa");
        System.out.println(user);
        // 基于@Query注解查询
        User user1 = userDao.findByName("aa");
        System.out.println(user1);
    }
    // 模糊查询
    @Test
    void getUsersByNameLike(){
        // 基于方法名称命名规则查询
        List<User> users = userDao.getByUserNameContaining("a");
        System.out.println(users);
        // 基于@Query注解查询
        List<User> users1 = userDao.findByKeyword("a");
        System.out.println(users1);
    }
    // 分页
    @Test
    void findAllToPage(){
        // 见service层
    }

}

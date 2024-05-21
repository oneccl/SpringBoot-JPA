package com.cc.springbootjpa.dao;

import com.cc.springbootjpa.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/8
 * Time: 10:38
 * Description:
 */
public interface UserDao extends
        JpaRepository<User,Integer>,
        CrudRepository<User,Integer>,
        JpaSpecificationExecutor<User>,
        PagingAndSortingRepository<User,Integer> {

    // JPA Java Persistence API（Java持久层API）
    /*
    JPA: 是描述对象-关系表的映射关系，并将运行时的实体类对象持久化到指定数据库的Spring Data模块
    作用：提供一套基于JPA标准操作数据库的简化方案，我们只需要定义实体类和Dao接口
        让Dao接口继承Spring Data JPA中提供的接口即可；Spring Data JPA在运行时会
        根据实体类自动创建数据库表(需要自己创建数据库)，不需要映射文件实现对数据库的各种操作
    JPA: 底层默认使用依赖Hibernate JPA实现
    JPA的使用：见本工程test\java\com\cc\springbootjpa\SpringBootJpaApplicationTests.java
     */
    // Spring Data JPA中提供的接口
    /*
    1)JpaRepository<实体类,主键类型>
    2)CrudRepository<实体类,主键类型>
    3)JpaSpecificationExecutor<实体类>: 此接口可用于实现动态条件查询，支持分页与排序
    4)PagingAndSortingRepository<实体类,主键类型>: 此接口可用于分页和排序
    四者都提供了对数据库的增删改查等功能，选择其一即可
     */
    // 如果提供的功能不能满足生产需求，可根据规则自定义方法
    /*
    Repository接口是Spring Data JPA中提供的所有接口的顶层接口
    Repository提供了两种查询方式的支持
    1)基于方法名称命名规则查询(会自动提示)
    规则：findBy/getBy/queryBy(关键字)+属性名称(属性名称首字母大写)+查询条件(首字母大写)
         getBy(关键字)+属性名称(属性名称首字母大写)+查询条件(首字母大写)
    2)基于@Query注解查询
     */

    /*  基于方法名称命名规则查询(会自动提示)  */

    // 根据用户名查询
    User getByUserName(String name);

    // 模糊查询
    List<User> getByUserNameContaining(String keyword);

    // 分页(service层重写分页规则)
    @Override
    Page<User> findAll(Pageable pageable);

    /*  基于@Query注解查询  */

    // 根据用户名查询: User：实体类 ?1：参数1
    @Query("from User where userName=?1")
    User findByName(String name);

    // 模糊查询: nativeQuery=true: 根据本地数据库查询(用于支持*写法)，默认false
    @Query(value = "select * from User where user_name like %?%",nativeQuery = true)
    List<User> findByKeyword(String keyword);

}

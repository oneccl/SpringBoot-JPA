package com.cc.springbootjpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/8
 * Time: 10:24
 * Description:
 */
// @Entity：标记实体类，可被ORM框架用于持续化，常与@Table一起使用，指定关联的数据库表
@Entity
// @Table：标注实体类与数据库表的对应关系，生成数据库表
@Table

@Data  // get()、set()方法
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    // @Id: 标注该属性为主键
    @Id
    // @GeneratedValue: 主键自增
    @GeneratedValue
    private Integer userId;

    // 生成数据库表时，驼峰命名法默认转化为下划线和小写 如userName -> user_name
    // @Column(name="userName") :标注实体类属性与数据库表字段的对应关系
    // 可使用该注解设置表的字段名
    private String userName;
    private String password;

    // @Enumerated 标注的属性为枚举类类型(Gender为枚举类)
    // private Gender gender;

    private String gender;
    private Integer age;

    // @JoinColumn(name="role_id") 标注本表中指向另一个表的外键
    // private Integer userRole;

    // @OneToOne 标注两个实体为一对一关系
    // private Role role;

    // @OneToMany(mappedBy = "accUserId") 标注两个实体为一对多关系
    // 指向多方的pojo的关联外键字段，mappedBy属性：指明拥有关系实体的关联属性名
    // private List<Account> accounts;

    // @ManyToOne 标注两个实体为多对一关系，设置在一方的pojo的外键字段上
    // 多个用户在一个地区
    // private Zone zoneId;


}

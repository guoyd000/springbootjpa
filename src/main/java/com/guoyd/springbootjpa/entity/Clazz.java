package com.guoyd.springbootjpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_clazz")
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cid;

    @Column
    String name;

    //一对多
    @OneToMany(mappedBy = "clazz")//创建一对多的映射关系，值是对方外键对应的属性名称
    private List<Student> list;

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public Integer getcId() {
        return cid;
    }

    public void setcId(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

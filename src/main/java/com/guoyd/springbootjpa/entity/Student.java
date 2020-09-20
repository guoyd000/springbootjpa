package com.guoyd.springbootjpa.entity;

import javax.persistence.*;

@Entity(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;

    @Column
    private String sname;

    @ManyToOne//多个学生属于同一个班级
    @JoinColumn(name = "cid")//指定外键列
    private Clazz clazz;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}

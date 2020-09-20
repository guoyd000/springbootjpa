package com.guoyd.springbootjpa.entity;

import javax.persistence.*;

@Entity(name = "t_city")
public class City {

    @Id //id唯一值
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column //注解标识pname就是一个普通的列，注解中有很多属性，我们可以都使用指定
    private String pname;

    @Column
    private String countryCode;
    @Column
    private String district;
    @Column
    private int population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}

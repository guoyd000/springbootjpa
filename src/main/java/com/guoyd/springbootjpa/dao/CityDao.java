package com.guoyd.springbootjpa.dao;

import com.guoyd.springbootjpa.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
// 创建dao实现City实体类的操作
// JpaRepository<T,ID>jpa提供的一个接口，
// JpaRepository继承自PagingAndSortingRepository接口，JpaRepository基于JPA的Repository接口，极大减少了JPA作为数据访问的代码，JpaRepository是实现Spring Data JPA技术访问数据库的关键接口。
public interface CityDao extends JpaRepository<City, Integer> {
    /**
     *
     * 自定义查询
     * 1、什么时候需要自定义查询
     * JpaRepository接口中无法正常实现实际业务需求，此时我们需要进行一个自定义查询
     *
     * 2、方法定义主义事项
     * 方法返回值是根据实际的业务需求定义：List pet
     * 方法的名称必须满足规范，findByXxx  findBy固定开始Xxx属性名称，findByPname
     */

    List<City> findByPname(String pname);

    List<City> findByDistrict(String district);

    List<City> findAllByPnameAndDistrict(String pname,String district);

    List<City> findAllByIdBetweenOrderById(int id,int maxId);
}

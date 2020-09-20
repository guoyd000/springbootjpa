package com.guoyd.springbootjpa;

import com.guoyd.springbootjpa.dao.CityDao;
import com.guoyd.springbootjpa.entity.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

//@RuntimeType
@SpringBootTest(classes = SpringbootjpaApplication.class)
class SpringbootjpaApplicationTests {

    @Autowired
    private CityDao cityDao;

    @Test
    void contextLoads1() {
        System.out.println("table创建成功~~~~~~~~~");
    }


    @Test
    void addCity() {
        System.out.println("city---->add");

        City city = new City();
        city.setPname("太原");
        city.setPopulation(20 * 10000);
        city.setDistrict("华北地区1");
        city.setCountryCode("156");
        // 完成添加操作
        City city1 = cityDao.save(city);
//        Pageable pageable = PageRequest.of(1, 15, Sort.Direction.DESC, "ID");
//        Page<City> all = deptDao.findAll(pageable);
//        all.forEach(System.out::println);
    }

    /**
     * save方法有两层意思
     * 如果没有指定id字段，直接会进入一个insert操作
     * 如果指定了id字段
     * 根据指定的id字段先去查询
     * 如果查询到对应的数据就进行更新操作
     * 如果根据id没有查询到对应的记录进行一个添加操作
     */
    @Test
    void updateCity() {
        System.out.println("city---->update");
        City city = new City();
        city.setId(55);
        city.setPname("石家庄");
        city.setPopulation(20 * 10000);
        city.setDistrict("华北地区1");
        city.setCountryCode("156");
        // 完成添加操作
        City city1 = cityDao.save(city);
//        Pageable pageable = PageRequest.of(1, 15, Sort.Direction.DESC, "ID");
//        Page<City> all = deptDao.findAll(pageable);
//        all.forEach(System.out::println);
    }

    @Test
    void queryCityById() {

        Optional<City> optional = cityDao.findById(1);
        City city = optional.get();
        System.out.println("city中id为1 的对象" + city.toString());
    }

    @Test
    void queryCityAll() {
//        List<City> cities = cityDao.findAll();
//        cities.forEach(System.out::println);
        List<City> cities = cityDao.findAll(Sort.by("id"));
        cities.forEach(System.out::println);
    }

    /**
     * 方法中的参数，
     * page总是从0开始，表示查询页，
     * size指每页的期望行数。
     *
     * Page接口可以获得当前页面的记录、总页数、总记录数、是否有上一页或下一页等
     * Spring Data翻页查询总是返回Page对象，Page对象提供了以下常用的方法
     * Direction可以设置排序
     */
    @Test
    void queryAllCityWithPage() {

        Pageable pageable = PageRequest.of(0, 20, Sort.Direction.DESC, "id");
        Page<City> cities = cityDao.findAll(pageable);
        cities.forEach(System.out::println);
    }

    /**
     * 删除操作
     */
    @Test
    void deleteCityWithPage() {

        City city = new City();
        city.setId(3);
        cityDao.delete(city);
    }

    /**
     * 自定义查询
     */
    @Test
    void queryCityByPname() {

        List<City> cities = cityDao.findByPname("石家庄");
        cities.forEach(System.out::println);
    }

    @Test
    void findByDistrict() {

        List<City> cities1 = cityDao.findByDistrict("华北地区1");
        cities1.forEach(System.out::println);
    }

    @Test
    void findAllByPnameAndDistrict() {

        List<City> cities1 = cityDao.findAllByPnameAndDistrict("石家庄","华北地区1");
        cities1.forEach(System.out::println);
    }

    @Test
    void findAllByIdBetweenOrderById() {

        List<City> cities1 = cityDao.findAllByIdBetweenOrderById(1,2);
        cities1.forEach(System.out::println);
    }


}

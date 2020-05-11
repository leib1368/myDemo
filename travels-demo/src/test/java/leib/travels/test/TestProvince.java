package leib.travels.test;

import leib.travels.dao.ProvinceDAO;
import leib.travels.enity.Province;
import leib.travels.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/4/30 13:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestProvince {

    @Autowired
    ProvinceDAO provinceDAO;
    @Autowired
    ProvinceService provinceService;

    @Test
    public void t1(){
        System.out.println(provinceDAO.findTotals());
    }
    @Test
    public void t2(){
        List<Province> list = provinceService.findByPage(1,3);
        list.forEach(pr->{
            System.out.println(pr);
        });
    }

}

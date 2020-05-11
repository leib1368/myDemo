package leib.demo;

import leib.demo.dao.UserDAO;
import leib.demo.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestUserDAO {

    @Autowired
    private UserDAO userDAO;



    //查询所有
    @Test
    public void testFindAll(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> users = userDAO.selectList(queryWrapper);
        users.forEach(user-> System.out.println("user = " + user));
    }
    
    //根据主键查询一个
    @Test
    public void testFindById(){
        User user = userDAO.selectById("2");
        System.out.println("user = " + user);
    }

    //条件查询
    @Test
    public void testFind(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("age",23);//设置等值查询
        //queryWrapper.lt("age",23);//设置小于查询
        //queryWrapper.ge("age",23);//小于等于查询 gt 大于  ge 大于等于
        List<User> users = userDAO.selectList(queryWrapper);
        users.forEach(user-> System.out.println(user));
    }

    //模糊查询
    @Test
    public void testFindLike(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //like %?% likeLeft %? 以xxx结尾  LikeRight ?%  以xxx开头
        queryWrapper.likeRight("username","小");
        List<User> users = userDAO.selectList(queryWrapper);
        users.forEach(user-> System.out.println("user = " + user));
    }


    //保存
    @Test
    public void testSave(){
        User entity = new User();
        entity.setName("xxx").setAge(45).setBir(new Date());
        userDAO.insert(entity);
    }

    //修改方法
    //基于主键id进行数据的修改
    @Test
    public void testUpdateById(){
        User user = userDAO.selectById("5");
        user.setName("chenyn");
        userDAO.updateById(user);
    }

    //批量修改
    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("百知教育-1");
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq("age",23);
        userDAO.update(user,updateWrapper);
    }

    //基于id删除一个
    @Test
    public void testDeleteById(){
        userDAO.deleteById("3");
    }

    //基于条件进行删除
    @Test
    public void testDelete(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",23);
        userDAO.delete(queryWrapper);
    }

    //分页查询使用
    @Test
    public void testFindPage(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",23);
        //参数1:当前页 默认值 1   参数2:每页显示记录数  默认值10
        IPage<User> page = new Page<>(1,2);
        IPage<User> userIPage = userDAO.selectPage(page, queryWrapper);
        long total = userIPage.getTotal();
        System.out.println("总记录数: "+total);
        userIPage.getRecords().forEach(user-> System.out.println("user = " + user));
    }

}


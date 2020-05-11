package leib.demo.controller;

import leib.demo.entity.User;
import leib.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    //模糊搜索方法
    @GetMapping("findLike")
    public List<User> findNameOrCode(String name,String code){
        return userService.findNameOrPhoneCode(name,code);
    }


    //查询一个方法
    @GetMapping("findOne")
    public User findOne(String  id){
        return userService.findOne(id);
    }

    //删除方法
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message","删除用户失败,请稍后再试!");
        }
        return map;
    }


    //保存用户方法
    @PostMapping("save")
    public Map<String, Object> save(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            if(StringUtils.isEmpty(user.getId())){
                userService.save(user);
            }else{
                userService.update(user);
            }
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "用户保存或更新失败!");
        }
        return map;
    }

    //查询所有方法
    @GetMapping("findAll")
    public List<User> findAll() {
        List<User> users = userService.findAll();
        return users;
    }

}

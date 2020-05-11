package leib.demo.controller;

import leib.demo.entity.User;
import leib.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 更新用户
     */
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            userService.update(user);
            map.put("success", true);
            map.put("msg", "更新用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("sucess", false);
            map.put("msg", "更新用户信息失败: " + e.getMessage());
        }
        return map;
    }

    /**
     * 查询一个
     */
    @GetMapping("findOne")
    public User findOne(String id) {
        return userService.finById(id);
    }

    /**
     * 删除用户
     */
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);
            map.put("msg", "删除用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("sucess", false);
            map.put("msg", "删除用户信息失败: " + e.getMessage());
        }
        return map;
    }

    /**
     * 添加用户
     */
    @PostMapping("add")
    public Map<String, Object> add(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            userService.save(user);
            map.put("success", true);
            map.put("msg", "添加用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("sucess", false);
            map.put("msg", "添加用户失败: " + e.getMessage());
        }
        return map;
    }

    /**
     * 查询所有开发
     */
    @GetMapping("findAll")
    public Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        List<User> results = userService.findAll();
        map.put("total", 10);
        map.put("totalPage", 1);
        map.put("page", page);
        map.put("results", results);
        return map;
    }


}

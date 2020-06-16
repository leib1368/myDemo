package leib.demo.controller;

import leib.demo.dto.UserDto;
import leib.demo.entity.User;
import leib.demo.service.UserService;
import leib.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/5/23 17:04
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("delete")
    private Result delete(String id){
        Result result = new Result();

        try {
            userService.delete(id);
            result.setMsg("删除成功");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg("删除失败");
            result.setStatus(false);
            //e.printStackTrace();
        }
        return result;

    }


    @GetMapping("findAll")
    private List<User> findAll(UserDto userDto){
        return userService.findAll(userDto);
    }

    @GetMapping("findTotal")
    private int findTotal(){
        return userService.findTotal();
    }

    @PostMapping("save")
    public Result save(@RequestBody User user){
        Result result = new Result();

        try {
            if (StringUtils.isEmpty(user.getId())) {
                userService.save(user);
                result.setMsg("保存成功");
            }else{
                userService.update(user);
                result.setMsg("更新成功");
            }


        } catch (Exception e) {
            result.setMsg("保存失败");
            result.setStatus(false);
            //e.printStackTrace();
        }
        return result;
    }

}

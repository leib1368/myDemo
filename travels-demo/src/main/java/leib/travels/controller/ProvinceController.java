package leib.travels.controller;

import leib.travels.enity.Province;
import leib.travels.enity.Result;
import leib.travels.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/4/30 14:34
 */
@RestController
@CrossOrigin
@RequestMapping("province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @PostMapping("update")
    public Result update(@RequestBody Province province) {
        Result result = new Result();
        try {
            provinceService.update(province);
            result.setMsg("修改省份信息成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    @GetMapping("findOne")
    public Province findOne(String id) {
        return provinceService.findOne(id);
    }


    @GetMapping("delete")
    public Result delete(String id) {
        //此时不用加@RequestBody
        Result result = new Result();
        try {
            provinceService.delete(id);
            result.setMsg("删除省份信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg("删除省份信息失败!!!");
        }
        return result;
    }

    @PostMapping("save")
    public Result  save(@RequestBody Province province){
        Result result = new Result();
        try{
            provinceService.saveProvince(province);
            result.setMsg("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("保存失败").setState(false);
        }
        return result;
    }

    @GetMapping("findByPage")
    public Map<String, Object> findByPage(Integer page, Integer rows) {
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Province> provinces = provinceService.findByPage(page, rows);
        //计算总页数
        Integer totals = provinceService.findTotals();
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("provinces", provinces);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }
}

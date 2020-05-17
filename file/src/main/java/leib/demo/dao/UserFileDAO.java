package leib.demo.dao;

import leib.demo.entity.UserFile;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/5/16 21:19
 */
public interface UserFileDAO {

    //根据登录用户id获取用户的文件列表
    List<UserFile> findByUserId(Integer id);

    //保存用户的文件记录
    void save(UserFile userFile);

    //根据文件id获取文件信息
    UserFile findById(String id);

    //根据id更新下载次数
    void update(UserFile userFile);

    //根据id删除记录
    void delete(String id);
}
package leib.demo.service;


import leib.demo.entity.UserFile;

import java.util.List;

public interface UserFileService {

    List<UserFile> findByUserId(Integer id);

    void save(UserFile userFile);

    UserFile findById(String id);

    void update(UserFile userFile);

    void delete(String id);
}

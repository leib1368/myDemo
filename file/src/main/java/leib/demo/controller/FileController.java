package leib.demo.controller;

import leib.demo.entity.User;
import leib.demo.entity.UserFile;
import leib.demo.service.UserFileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author:Leib
 * @Date 2020/5/16 22:06
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private UserFileService userFileService;

    @Value("${upload.dir}")
    private String uploadPath;

    /**
     * 返回当前用户的所有文件列表---json格式数据
     */
    @GetMapping("findAllJSON")
    @ResponseBody
    public List<UserFile> findAllJSON(HttpSession session, Model model) {
        //在登录的session中获取用户的id
        User user = (User) session.getAttribute("user");
        //根据用户id查询有的文件信息
        List<UserFile> userFiles = userFileService.findByUserId(user.getId());
        return userFiles;
    }


    /**
     * 删除文件信息
     */
    @GetMapping("delete")
    public String delete(String id) throws FileNotFoundException {

        //根据id查询信息
        UserFile userFile = userFileService.findById(id);

        String pathString =  ResourceUtils.getURL("classpath:").getPath() + "/static";

        //删除文件
        String realPath =  uploadPath  + userFile.getPath();
        File file = new File(realPath, userFile.getNewFileName());
        if(file.exists())file.delete();//立即删除

        //删除数据库中记录
        userFileService.delete(id);

        return "redirect:/file/showAll";
    }


    /**
     * 文件下载
     */
    @GetMapping("download")
    public void download(String openStyle, String id, HttpServletResponse response) throws IOException {
        //获取打开方式
        openStyle = openStyle == null ? "attachment" : openStyle;
        //获取文件信息
        UserFile userFile = userFileService.findById(id);
        //点击下载链接更新下载次数
        if ("attachment".equals(openStyle)) {
            userFile.setDowncounts(userFile.getDowncounts() + 1);
            userFileService.update(userFile);
        }
        //根据文件信息中文件名字 和 文件存储路径获取文件输入流
        String realPath =  uploadPath  + userFile.getPath();
        //String realpath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();
        //获取文件输入流

        FileInputStream is = new FileInputStream(new File(realPath, userFile.getNewFileName()));
        //附件下载
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(userFile.getOldFileName(), "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //文件拷贝
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }


    /**
     * 上传文件处理 并保存文件信息到数据库中
     */
    @PostMapping("upload")
    public String upload(MultipartFile aaa, HttpSession session) throws IOException {
        //获取上传文件用户id
        User user = (User) session.getAttribute("user");
        //获取文件原始名称
        String oldFileName = aaa.getOriginalFilename();

        //获取文件后缀
        String extension = "." + FilenameUtils.getExtension(aaa.getOriginalFilename());

        //生成新的文件名称
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-", "") + extension;

        //文件大小
        Long size = aaa.getSize();

        //文件类型
        String type = aaa.getContentType();

        //处理根据日期生成目录
        //String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateDirPath = uploadPath + "/files/" + dateFormat;
        File dateDir = new File(dateDirPath);
        if (!dateDir.exists()) dateDir.mkdirs();

        //处理文件上传
        aaa.transferTo(new File(dateDir, newFileName));

        //将文件信息放入数据库保存
        UserFile userFile = new UserFile();
        userFile.setOldFileName(oldFileName).setNewFileName(newFileName).setExt(extension).setSize(String.valueOf(size))
                .setType(type).setPath("/files/" + dateFormat).setUserId(user.getId());
        userFileService.save(userFile);

        return "redirect:/file/showAll";
    }

    /**
     * 展示所有文件信息
     */
    @GetMapping("showAll")
    public String findAll(HttpSession session, Model model) {
        //在登录的session中获取用户的id
        User user = (User) session.getAttribute("user");

        //根据用户id查询有的文件信息
        List<UserFile> userFiles = userFileService.findByUserId(user.getId());
        //存入作用域中
        model.addAttribute("files", userFiles);
        return "showAll";
    }
}

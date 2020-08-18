package cn.tedu.gyf.controller;

import cn.tedu.gyf.common.vo.ImageVO;
import cn.tedu.gyf.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Date 2020/8/5 15:27
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@RestController
public class UploadController {

    @Resource
    private FileService fileService;

    @RequestMapping("/pic/upload")
    public ImageVO uploadPic(MultipartFile uploadFile) throws IOException {
        return fileService.uploadFile(uploadFile);
    }
}

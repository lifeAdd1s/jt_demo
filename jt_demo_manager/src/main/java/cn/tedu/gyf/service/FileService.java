package cn.tedu.gyf.service;

import cn.tedu.gyf.common.vo.ImageVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Date 2020/8/5 15:40
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
public interface FileService {
    ImageVO uploadFile(MultipartFile uploadFile) throws IOException;
}

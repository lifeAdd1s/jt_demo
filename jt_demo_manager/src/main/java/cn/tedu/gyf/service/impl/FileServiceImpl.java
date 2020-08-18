package cn.tedu.gyf.service.impl;

import cn.tedu.gyf.common.vo.ImageVO;
import cn.tedu.gyf.dao.ItemDao;
import cn.tedu.gyf.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @Date 2020/8/5 15:41
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private ItemDao itemDao;

    @Value("${image.url.path}")
    private String url ;

    @Value("${image.local.path}")
    private String localRootPath;


    /*
    * 1.检验文件是否有效
    * 2.检验程序是否为恶意程序
    * 2.分目录存储
    * 4.自定义文件名称
    * 5.保存文件到物理路径
    * 6.为文件赋予虚拟路径，方便网络访问
    *
    * */
    @Override
    public ImageVO uploadFile(MultipartFile uploadFile) {

        Map<Integer,Integer> map=new HashMap<>();

        //上传文件类型校验
        //1.校验是否是图片类型
        String filename=uploadFile.getOriginalFilename().toLowerCase();
        String regex=".+(\\.(gif|png|jpg|jpeg|webp|svg|psd|bmp|tif))$";
        Boolean res=filename.matches(regex);
        if(!res)
            return ImageVO.fail();

        //2.校验是否时图片，防止上传恶意文件
        try{
            BufferedImage bufferedImage=ImageIO.read(uploadFile.getInputStream());
            int width= bufferedImage.getWidth();
            int height=bufferedImage.getHeight();

            if(width==0||height==0){
               return ImageVO.fail();
            }
        }catch (IOException e){
            e.printStackTrace();
            return ImageVO.fail();
        }

        //3.分目录存储
        //方案1：hash截取
        //方案2：利用时间创建不同目录

        String datePath=new SimpleDateFormat("/yyyy/MM/dd/").format(new Date()).toString();
        String savePath=localRootPath+datePath;

        File file=new File(savePath);
        if(!file.exists()){
            file.mkdirs();
        }

        //4.自定义文件名称,保存到实际的物理路径
        //uuid作为文件名
        int index=filename.lastIndexOf('.');
        String fileType=filename.substring(index);
        String newFileName= UUID.randomUUID().toString().replace("-","")+fileType;

        String realFilePath=savePath+newFileName;
        File imageFile=new File(realFilePath);

        //保存文件
        try{
            uploadFile.transferTo(imageFile);
        }catch (IOException e){
            e.printStackTrace();
            return ImageVO.fail();
        }

        String vitualUrl = url+datePath+newFileName;
        System.out.println(vitualUrl);

        return ImageVO.success(vitualUrl);
    }

}

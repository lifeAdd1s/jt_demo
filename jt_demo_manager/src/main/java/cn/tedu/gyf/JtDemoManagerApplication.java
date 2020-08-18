package cn.tedu.gyf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.tedu.gyf")
@MapperScan(basePackages = "cn.tedu.gyf.dao")
public class JtDemoManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtDemoManagerApplication.class, args);
    }

}

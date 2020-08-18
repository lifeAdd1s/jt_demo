package cn.tedu.gyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JtDemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtDemoWebApplication.class, args);
    }

}

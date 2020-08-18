package cn.tedu.gyf.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Date 2020/8/3 16:17
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EasyUITree implements Serializable {

    private Long id;

    private String text;

    private String state;
}

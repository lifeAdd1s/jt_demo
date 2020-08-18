package cn.tedu.gyf.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
* @Date 2020/7/31 11:57
* @Author GuoYunFeng
* @Email guoyunfeng520@outllok.com
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
 public class EasyUITable<T> {

     private Long total;

     private List<T> rows;
}

package com.example.pojo;

import lombok.Data;
import java.util.List;

/**
 * 分页查询结果
 * @param <T>
 */
@Data
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}

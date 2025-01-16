package com.sky.service;


import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    /**
     * 新增菜品分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 菜品分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据种类id删除菜品分类
     * @param id
     */
    void deleteById(Long id);

    /**
     * 修改菜品种类
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 菜品启用或禁用状态
     * @param status
     * @param id
     */
    void startOrStop( Integer status, Long id);

    /**
     * 根据类型查询所有启用的分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}

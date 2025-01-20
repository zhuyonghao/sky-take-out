package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {
    /**
     * 根据种类查询套餐数量
     * @param categoryId
     * @return
     */
    @Select("select count(*) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    List<Long> getSetmealIdsByDishIds(List<Long> dishids);
}

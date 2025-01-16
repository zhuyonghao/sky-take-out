package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 菜品分类管理
 */
@RestController                                 // controller类
@RequestMapping("/admin/category")            //  设置共同路径
@Api(tags = "菜品分类相关接口")                    // swagger文档标记
@Slf4j                                           // 日志注解
public class CategoryController {

    // 依赖注入
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增菜品分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增菜品分类")
    public Result save(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类：{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("菜品分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("菜品分页查询：{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }


    /**
     * 根据ID删除菜品分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据种类id删除菜品分类")
    public Result deleteById(Long id){
        log.info("要删除的菜品id: {}", id);
        categoryService.deleteById(id);
        return Result.success();
    }


}

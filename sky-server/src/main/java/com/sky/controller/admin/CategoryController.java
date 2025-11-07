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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/category")
@Slf4j
@Api(tags = {"类别相关操作"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //TODO 分类分页查询

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分类分页查询：{}",categoryPageQueryDTO);

        PageResult pageResult  = categoryService.page(categoryPageQueryDTO);

        return Result.success(pageResult);
    }














    //TODO 新增分类
    //TODO 根据id删除分类
    //TODO 启用、禁用分类
    //TODO 根据类型查询分类


}

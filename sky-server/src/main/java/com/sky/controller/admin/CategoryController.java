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

@RestController
@RequestMapping("admin/category")
@Slf4j
@Api(tags = {"类别相关操作"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


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


    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result add(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类:{}",categoryDTO);
        categoryService.add(categoryDTO);

        return Result.success();
    }

    //TODO 添加逻辑 如果分类下面有套餐或者菜品 那么这个分类不能被删除 抛出异常
    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result delete(Long id){
        log.info("根据id删除分类：{}",id);

        categoryService.delete(id);

        return Result.success();

    }

    /**
     * 启用、禁用分类
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用、禁用分类")
    public Result startOrStop(@PathVariable Integer status,Long id){
        log.info("启用、禁用分类：{},{}",status,id);

        categoryService.startOrStop(status,id);

        return Result.success();
    }

    //TODO 根据类型查询分类


    @PutMapping
    @ApiOperation("修改分类")
    public Result refresh(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类：{}",categoryDTO);

        categoryService.refresh(categoryDTO);

        return Result.success();
    }

}

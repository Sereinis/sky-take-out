package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /*
    * 根据菜品id查询菜品下的套餐
    * @param dishId
    * @return
    */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 新增套餐菜品关联
     * @param setmealDishList
     */

    void insertBatch(List<SetmealDish> setmealDishList);

    /**
     * 根据套餐id查询套餐菜品关联
     * @param id
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{id}")
    List<SetmealDish> selectBySetmealId(Long id);

    /**
     * 根据套餐id批量删除套餐菜品关联
     * @param ids
     */
    @Delete("delete from setmeal_dish where setmeal_id in (#{ids})")
    void deleteBatchSetmealIds(List<Long> ids);

    /**
     * 根据套餐id删除套餐菜品关联
     * @param id
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{id}")
    void delete(Long id);
}

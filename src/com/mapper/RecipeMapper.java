package com.mapper;

import com.pojo.Recipe;
import com.pojo.RecipeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecipeMapper {
    int countByExample(RecipeExample example);

    int deleteByExample(RecipeExample example);

    int deleteByPrimaryKey(String rid);

    int insert(Recipe record);

    int insertSelective(Recipe record);

    List<Recipe> selectByExample(RecipeExample example);

    Recipe selectByPrimaryKey(String rid);

    int updateByExampleSelective(@Param("record") Recipe record, @Param("example") RecipeExample example);

    int updateByExample(@Param("record") Recipe record, @Param("example") RecipeExample example);

    int updateByPrimaryKeySelective(Recipe record);

    int updateByPrimaryKey(Recipe record);
    
    List<Recipe> selectByTime();
    
    List<Recipe> selectByIds(List<String> list);
    
    List<Recipe> selectByKey(String key);
    
}
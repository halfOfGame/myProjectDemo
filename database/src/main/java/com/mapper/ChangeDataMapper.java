package com.mapper;

import com.domain.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface ChangeDataMapper {

    @Update("update t_test_change set data1 = #{data1}, data2 = #{data2}, data3 = #{data3} where id = 1")
    public void ChangeData(@Param("data1")String data1, @Param("data2")String data2, @Param("data3")String data3);

    @Select("select data1, data2, data3 from t_test_change")
    public Data getData();
}

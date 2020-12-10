package com.example.mydemo2.mapper;

import com.example.mydemo2.domain.ThreeDimensionData;
import com.example.mydemo2.domain.TwelveDimensionData;
import com.example.mydemo2.domain.TwoDimensionData;
import com.example.mydemo2.domain.FiveDimensionData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EchartsMapper {

    @Select("select xData, yData from t_goods_count")
    public List<TwoDimensionData> getGoodsCount();

    @Select("select data1, data2, data3, data4, data5 from t_funnel_count")
    public FiveDimensionData getFunnelCount();

    @Select("select data1, data2, data3, data4, data5 from t_two_dimension where id = #{id}")
    public FiveDimensionData getFiveDimension(@Param("id")Integer id);


    @Select("select data1, data2, data3, data4, data5, data6, data7, data8, data9, data10, data11, data12 from t_twelve_dimension where id = #{id}")
    public TwelveDimensionData getTwelveDimension(@Param("id")Integer id);

    @Select("select data1, data2, data3 from t_test_change")
    public ThreeDimensionData getThreeDimensionData();


    @Select("select data1, data2, data3, data4, data5 from t_two_dimension where id = #{id}")
    public List<FiveDimensionData> test(@Param("id")Integer id);

    @Update("update t_test_change set data1 = #{data1}, data2 = #{data2}, data3 = #{data3} where id = 1")
    public void changeData(@Param("data1")String data1, @Param("data2")String data2, @Param("data3")String data3);

}

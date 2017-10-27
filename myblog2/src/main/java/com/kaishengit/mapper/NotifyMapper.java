package com.kaishengit.mapper;

import com.kaishengit.entity.Notify;
import com.kaishengit.entity.NotifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotifyMapper {
    long countByExample(NotifyExample example);

    int deleteByExample(NotifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notify record);

    int insertSelective(Notify record);

    List<Notify> selectByExample(NotifyExample example);

    Notify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notify record, @Param("example") NotifyExample example);

    int updateByExample(@Param("record") Notify record, @Param("example") NotifyExample example);

    int updateByPrimaryKeySelective(Notify record);

    int updateByPrimaryKey(Notify record);
}
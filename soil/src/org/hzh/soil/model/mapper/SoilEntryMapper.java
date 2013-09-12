/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hzh.soil.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import org.hzh.soil.model.data.SoilEntry;

/**
 *
 * @author wei lu
 */
public interface SoilEntryMapper {

    final String INSERT = "insert into soil_entry (id, lng, lat, ph, timestamp) VALUES(#{obj.id}, #{obj.lng}, #{obj.lat}, #{obj.ph}, #{obj.timestamp})";
    final String UPDATE = "UPDATE soil_entry SET lng= #{obj.lng}, lat= #{obj.lat}, ph=#{obj.ph}, timestamp=#{obj.timestamp} WHERE ID = #{obj.id}";
    final String SELECT_BY_ID = "SELECT * FROM soil_entry WHERE id = #{id}";
    final String SELECT_BY_PH = "select * from soil_entry where ph>=#{phMin} and ph<=#{phMax}";
    final String SELECT_ALL = "SELECT * FROM soil_entry";
    final String DELETE = "DELETE FROM soil_entry WHERE ID = #{id}";

    @Insert(INSERT)
    //@Options(useGeneratedKeys = true, keyProperty = "obj.id")
    void insert(@Param("obj") SoilEntry cq);
    
    @Update(UPDATE)
    void update(@Param("obj") SoilEntry cq);
    


        
        
    @Select(SELECT_BY_ID)
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "lng", column = "lng"),
        @Result(property = "lat", column = "lat"),
        @Result(property = "ph", column = "ph"),
        @Result(property = "timestamp", column = "timestamp")
    })
    List<SoilEntry> selectById(@Param("id") int id);
    
    @Select(SELECT_ALL)
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "lng", column = "lng"),
        @Result(property = "lat", column = "lat"),
        @Result(property = "ph", column = "ph"),
        @Result(property = "timestamp", column = "timestamp")
    })
    List<SoilEntry> selectAll();
    
    @Select(SELECT_BY_PH)
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "lng", column = "lng"),
        @Result(property = "lat", column = "lat"),
        @Result(property = "ph", column = "ph"),
        @Result(property = "timestamp", column = "timestamp")
    })
    List<SoilEntry> selectPhRange(@Param("phMin") double min, @Param("phMax") double max);
    
    @Delete(DELETE)
    void deleteById(@Param("id") int id);
}

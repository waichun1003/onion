package com.example.coreonion.mapper;

import com.example.coreonion.model.UserActivity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserActivityMapper {
    void insertActivity(UserActivity activity);

}

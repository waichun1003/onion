package com.example.coreonion.mapper;

import com.example.coreonion.model.Content;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContentMapper {

    Content findContentById(@Param("contentId") Long contentId);

    void insertContent(Content content);

    List<Content> searchContent(@Param("query") String query);
}

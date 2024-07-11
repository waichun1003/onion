package com.example.coreonion.service;

import com.example.coreonion.mapper.ContentMapper;
import com.example.coreonion.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    @Autowired
    private ContentMapper contentMapper;

    public void createContent(Content content) {
        contentMapper.insertContent(content);
    }

    public Content getContentById(Long contentId) {
        return contentMapper.findContentById(contentId);
    }

    public List<Content> searchContent(String query) {
        return contentMapper.searchContent(query);
    }
}

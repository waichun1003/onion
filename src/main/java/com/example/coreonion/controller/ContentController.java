package com.example.coreonion.controller;

import com.example.coreonion.model.Content;
import com.example.coreonion.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<String> createContent(@RequestBody Content content) {
        contentService.createContent(content);
        return ResponseEntity.status(HttpStatus.CREATED).body("Content created successfully");
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<Content> getContentById(@PathVariable Long contentId) {
        Content content = contentService.getContentById(contentId);
        return ResponseEntity.ok(content);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Content>> searchContent(@RequestParam String query) {
        List<Content> contentList = contentService.searchContent(query);
        return ResponseEntity.ok(contentList);
    }
}

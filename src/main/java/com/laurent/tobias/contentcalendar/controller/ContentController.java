package com.laurent.tobias.contentcalendar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.laurent.tobias.contentcalendar.model.Content;
import com.laurent.tobias.contentcalendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    
    private final ContentCollectionRepository contentCollectionRepository;

    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.contentCollectionRepository = contentCollectionRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return contentCollectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return contentCollectionRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        contentCollectionRepository.save(content);
    }

    @PostMapping("")
    public void update(@RequestBody Content content, Integer id) {
        contentCollectionRepository.update(content, id); // TODO https://youtu.be/UgX5lgv4uVM?t=5031
    }
}

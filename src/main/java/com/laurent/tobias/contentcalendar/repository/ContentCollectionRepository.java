package com.laurent.tobias.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.laurent.tobias.contentcalendar.model.Content;
import com.laurent.tobias.contentcalendar.model.Status;
import com.laurent.tobias.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content newContent) {
        contentList.add(newContent);
    }

    @PostConstruct
    private void init() {
        Content newContent = new Content(
                1,
                "My first Blog Post",
                "My first Blog Post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now(),
                "");
        contentList.add(newContent);
    }

}

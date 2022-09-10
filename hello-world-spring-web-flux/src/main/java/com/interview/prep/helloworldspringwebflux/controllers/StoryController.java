package com.interview.prep.helloworldspringwebflux.controllers;

import com.interview.prep.helloworldspringwebflux.models.Story;
import com.interview.prep.helloworldspringwebflux.repositories.StoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public class StoryController {

    StoryRepository storyRepository = new StoryRepository();

    @GetMapping
    private Flux<Story> getAllStories() {

        return null;
    }
}

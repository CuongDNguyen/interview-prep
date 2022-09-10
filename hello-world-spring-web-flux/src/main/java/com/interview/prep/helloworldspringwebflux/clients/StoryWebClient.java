package com.interview.prep.helloworldspringwebflux.clients;

import com.interview.prep.helloworldspringwebflux.models.Story;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class StoryWebClient {
        WebClient client = WebClient.create("http://localhost:8080");

    void getStories() {
        Flux<Story> storyFlux = client.get()
                .uri("/stories")
                .retrieve()
                .bodyToFlux(Story.class);

        storyFlux.subscribe(System.out::println);
    }
}

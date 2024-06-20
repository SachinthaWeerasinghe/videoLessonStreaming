package com.example.VideoLessonstreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class VideoLessonStreaming {

    @Autowired
    private StreamingService service;

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        return service.getVideo(title);
    }

    @GetMapping(value = "courseResources/{title}", produces = MediaType.APPLICATION_PDF_VALUE)
    public Mono<Resource> getPdf(@PathVariable String title) {
        return service.getPdf(title);
    }

    @GetMapping(value = "tutorials/{title}", produces = MediaType.APPLICATION_PDF_VALUE)
    public Mono<Resource> getTutorial(@PathVariable String title) {
        return service.getTutorial(title);
    }

    public static void main(String[] args) {
        SpringApplication.run(VideoLessonStreaming.class, args);
    }

}























/*
package com.example.VideoLessonstreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class VideoLessonStreaming {

    @Autowired
    private StreamingService service;


    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        return service.getVideo(title);
    }

    public static void main(String[] args) {
        SpringApplication.run(VideoLessonStreaming.class, args);
    }

}
*/
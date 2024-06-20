package com.example.VideoLessonstreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {

    private static final String VIDEO_FORMAT = "classpath:video/%s.mp4";
    private static final String PDF_FORMAT = "classpath:courseResources/%s.pdf";
    private static final String TUTORIAL_FORMAT = "classpath:tutorials/%s.pdf";

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(VIDEO_FORMAT, title)));
    }

    public Mono<Resource> getPdf(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(PDF_FORMAT, title)));
    }

    public Mono<Resource> getTutorial(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(TUTORIAL_FORMAT, title)));
    }
}













/*
package com.example.VideoLessonstreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {

    private static final String FORMAT="classpath:video/%s.mp4";

    @Autowired
    private ResourceLoader resourceLoader;


    public Mono<Resource> getVideo(String title){
     return Mono.fromSupplier(()->resourceLoader.
             getResource(String.format(FORMAT,title)))   ;
    }
}


 */
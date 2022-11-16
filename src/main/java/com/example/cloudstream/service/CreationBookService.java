package com.example.cloudstream.service;

import com.example.cloudstream.model.Book;
import com.example.cloudstream.util.BookGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(Source.class)
@AllArgsConstructor
@EnableScheduling
public class CreationBookService {
    private final Source source;
    private final BookGenerator bookGenerator;

    @Scheduled(fixedRate = 10000)
    private void sendMessage() {
        Book book = bookGenerator.generateNewBook();
        log.info("sendMessage: " + book);
        source
                .output()
                .send(
                        MessageBuilder.withPayload(book).build()
                );
    }
}

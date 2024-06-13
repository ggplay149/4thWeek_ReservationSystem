package com.week4.concert.domain.queue;

import com.week4.concert.infrastructure.queue.QueueEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueAppender {

    private final QueueRepository queueRepository;

    public void insert(QueueEntity queue) {  }
}

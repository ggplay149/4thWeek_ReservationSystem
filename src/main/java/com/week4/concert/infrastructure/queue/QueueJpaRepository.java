package com.week4.concert.infrastructure.queue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueJpaRepository extends JpaRepository<QueueEntity,Long> {

}

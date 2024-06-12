package com.week4.concert.infrastructure.queue;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "queue")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QueueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,updatable = false)
    private Long id;

    @Column(name = "user_id" ,nullable = false)
    private Long userId;

}

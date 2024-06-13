package com.week4.concert.application;

import com.week4.concert.admin.MessageService;
import com.week4.concert.domain.concert.Concert;
import com.week4.concert.domain.concert.ConcertService;
import com.week4.concert.domain.payment.PaymentService;
import com.week4.concert.domain.payment.event.PaymentEvent;
import com.week4.concert.domain.queue.QueueService;
import com.week4.concert.domain.reservation.ReservationService;
import com.week4.concert.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PaymentUseCase {

    private final PaymentService paymentService;
    private final QueueService queueService;
    private final MessageService messageService;
    private final ReservationService reservationService;
    private final ConcertService concertService;
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public String pay(String reservationNumber, Long userId) {

        long startTime = System.nanoTime();
        Long reservedConcertId = reservationService.getReservedConcertId(reservationNumber);

        Concert reservedConcert = concertService.getConcertById(reservedConcertId);

        paymentService.pay(reservationNumber, userId);

        reservationService.finalizeConfirmation(reservationNumber,reservedConcert.title(),userId);

        concertService.increaseReservationCount(reservedConcertId);

        userService.usePoint(userId, reservedConcert.price());

        messageService.send();

        reservationService.removeTemporaryReservation(reservationNumber);
        long endTime = System.nanoTime(); long duration = endTime - startTime;
        System.out.println("Transaction duration: " + duration + " nanoseconds");
        return "정상 결제되었습니다. 예약이 확정되었습니다.";
    }

}




package com.week4.concert.domain.reservation;

import com.week4.concert.infrastructure.reservation.ReservationEntity;

import java.util.List;

public interface ReservationRepository {



    List<Integer> selectReservedSeat(String date, String title);

    void reserve(ReservationEntity reservation);

    void cancelNotConfirmReservation();

    Reservation validReservationNumber(String reservationNumber);

    void finalConfirm(String reservationNumber);

    void checkReservation(String reservationNumber);
}

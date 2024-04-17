package com.week4.concert.UnitTest.domain.reservation;

import com.week4.concert.Fixtures;
import com.week4.concert.domain.concert.Concert;
import com.week4.concert.domain.concert.ConcertReader;
import com.week4.concert.domain.concert.ConcertService;
import com.week4.concert.domain.reservation.ReservationReader;
import com.week4.concert.domain.reservation.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ReservationServiceTest {


    private ReservationService reservationService;
    private ReservationReader reservationReader;

    @BeforeEach
    void setUp() {
        reservationReader = mock(ReservationReader.class);
        reservationService = new ReservationService(reservationReader);
    }

    @Test
    @DisplayName("예약된 좌석 리스트 출력")
    void reservedSeat() {
        //given
        List<Integer> list = Fixtures.reservedList("아이유콘서트");
        given(reservationReader.reservedSeat(any(),any())).willReturn(list);
        //when
        List<Integer> result = reservationService.reservedSeat("202020","아이유콘서트");

        //then
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(9)).isEqualTo(10);
        assertThat(result.size()).isEqualTo(10);

    }

}
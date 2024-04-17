package com.week4.concert.api;

import com.week4.concert.api.dto.ReservationResponse;
import com.week4.concert.useCase.ReservationUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Concert API Controller", description = "예약 가능 날짜/좌석 조회 제공")
@RestController("reservation")
public class ReservationController {

    private final ReservationUseCase reservationUseCase;

    public ReservationController(ReservationUseCase reservationUseCase) {
        this.reservationUseCase = reservationUseCase;
    }

    @Operation(summary = "해당날짜/해당공연의 잔여좌석 조회", description = "Parameter example) concert_date : 20241112, concert_title : MuseConcert")
    @GetMapping("/availableSeat")
    public ResponseEntity<ReservationResponse> findAvailableSeat(
            @RequestParam("concert_date") String date, @RequestParam("concert_title") String title) {
        return ResponseEntity.ok().body(
                ReservationResponse.builder()
                        .availabelSeats(reservationUseCase.selectAvailableSeat(date,title))
                        .build());
    }
}
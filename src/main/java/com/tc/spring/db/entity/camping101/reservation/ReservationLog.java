package com.tc.spring.db.entity.camping101.reservation;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.tc.spring.db.entity.camping101.base.BaseCreateDateTimeEntity;
import com.tc.spring.db.entity.camping101.camp.enums.ReservationType;
import com.tc.spring.db.entity.camping101.reservation.enums.ReservationStatus;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ReservationLog extends BaseCreateDateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "reservation_log_id")
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Long payment;

    @Column(nullable = false)
    private Long siteId;

    @Column(nullable = false)
    private String siteName;

    // 예약 로그인지 예약 취소 로그인지 확인하려면, Reservation을 확인해야 하나?
    // 아니면 여기서 ReservationStatus를 넣어야 하나
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

}

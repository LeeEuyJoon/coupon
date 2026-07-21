package luti.coupon.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import luti.coupon.domain.model.PointChargeHistory;

public interface PointChargeHistoryRepository extends JpaRepository<PointChargeHistory, Long> {
}

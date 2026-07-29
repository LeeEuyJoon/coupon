package luti.coupon.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import luti.coupon.domain.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
	List<Campaign> findAllByOrderByIdDesc();
}

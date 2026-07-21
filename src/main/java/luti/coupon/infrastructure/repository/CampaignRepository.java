package luti.coupon.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import luti.coupon.domain.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
	Optional<Campaign> findById(Long id);
}

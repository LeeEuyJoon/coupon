package luti.coupon.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.PointChargeHistory;
import luti.coupon.domain.port.PointChargeHistoryStore;
import luti.coupon.infrastructure.repository.PointChargeHistoryRepository;

@Repository
@RequiredArgsConstructor
public class PointChargeHistoryStoreImpl implements PointChargeHistoryStore {

	private final PointChargeHistoryRepository repository;

	@Override
	public PointChargeHistory save(PointChargeHistory history) {
		return repository.save(history);
	}
}

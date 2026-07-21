package luti.coupon.domain.port;

import luti.coupon.domain.model.PointChargeHistory;

public interface PointChargeHistoryStore {
	PointChargeHistory save(PointChargeHistory history);
}

package ro.agilehub.javacourse.designpatterns.strategy;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class StrategyCandidate {

    private static record ReservationDO(String userId, String carId) {
    }

    // BEFORE

    public List<ReservationDO> findReservations(String userId, String carId, ReservationStatus status) {
        // userid, carId and status are optional
        if (userId != null && carId != null && status != null) {
            return findBy(userId, carId, status);
        } else if (userId != null && carId != null) {
            return findBy(userId, carId);
        } else {
            return findAll();
        }
    }

    public List<ReservationDO> findBy(String userId, String carId, ReservationStatus status) {
        return Collections.emptyList();
    }

    public List<ReservationDO> findBy(String userId, String carId) {
        return Collections.emptyList();
    }

    public List<ReservationDO> findAll() {
        return Collections.emptyList();
    }

    // AFTER

    // TODO: review social login to show how a strategy pattern could be implemented in Spring

    private enum FindStrategy {

        USER_CAR_STATUS(StrategyCandidate::findByUserCarStatus),
        USER_CAR(StrategyCandidate::findByUserCar),
        NOTHING(StrategyCandidate::findByNothing);

        private Function<Filter, List<ReservationDO>> providerWithFilter;

        FindStrategy(Function<Filter, List<ReservationDO>> providerWithFilter) {
            this.providerWithFilter = providerWithFilter;
        }

        public Function<Filter, List<ReservationDO>> getProviderWithFilter() {
            return providerWithFilter;
        }
    }

    public static List<ReservationDO> findByUserCarStatus(Filter filter) {
        return Collections.emptyList();
    }

    public static List<ReservationDO> findByUserCar(Filter filter) {
        return Collections.emptyList();
    }

    public static List<ReservationDO> findByNothing(Filter filter) {
        return Collections.emptyList();
    }

}

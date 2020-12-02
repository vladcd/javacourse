package ro.agilehub.javacourse.designpatterns.observer.parent;

import java.time.LocalDate;

public interface ParentServiceObserver {

    void notifyStartDateUpdated(Integer parentId, LocalDate newStartDate);
}

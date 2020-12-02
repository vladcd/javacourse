package ro.agilehub.javacourse.designpatterns.observer.parent;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.designpatterns.observer.child.ChildService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ParentService {

    private List<ParentServiceObserver> observers = new ArrayList<>();

    public ParentObject findById(Integer id) {
        return ParentObject.builder()
                .id(id)
                .name("Test " + id)
                .startDate(LocalDate.now())
                .build();
    }

    public void updateStartDate(Integer id, LocalDate newStartDate) {
        ParentObject parentObject = findById(id);
        parentObject.setStartDate(newStartDate);

        notifyStartDateUpdate(id, newStartDate);
    }

    // TODO: refactor using the observer pattern

    public void addObserver(ParentServiceObserver parentServiceObserver) {
        observers.add(parentServiceObserver);
    }

    public void notifyStartDateUpdate(Integer id, LocalDate newStartDate) {
        observers.forEach(parentServiceObserver -> parentServiceObserver.notifyStartDateUpdated(id, newStartDate));
    }
}

package ro.agilehub.javacourse.designpatterns.observer.child;

import ro.agilehub.javacourse.designpatterns.observer.parent.ParentService;
import ro.agilehub.javacourse.designpatterns.observer.parent.ParentServiceObserver;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ChildService implements ParentServiceObserver {

    private final ParentService parentService;

    private Map<Integer, ChildObject> cache = new ConcurrentHashMap<>();

    public ChildService(ParentService parentService) {
        this.parentService = parentService;

        this.parentService.addObserver(this);
    }

    public List<ChildObject> findByParentId(Integer parentId) {
        return cache.values().stream()
                .filter(childObject -> childObject.getParentId().equals(parentId))
                .collect(Collectors.toList());
    }

    // creates a child with the same start date as the parent
    public ChildObject add(Integer parentId, String name) {
        var parentObject = parentService.findById(parentId);
        cache.put(parentId, ChildObject.builder()
                .parentId(parentId)
                .id(parentId)
                .name("Test child " + parentId)
                .startDate(parentObject.getStartDate())
                .build());
        return cache.get(parentId);
    }

    public void updateStartDate(Integer parentId, LocalDate newStartDate) {
        findByParentId(parentId)
                .forEach(childObject -> childObject.setStartDate(newStartDate));
    }

    @Override
    public void notifyStartDateUpdated(Integer parentId, LocalDate newStartDate) {
        this.updateStartDate(parentId, newStartDate);
    }
}

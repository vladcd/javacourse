package ro.agilehub.javacourse.designpatterns.observer.child;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ChildObject {

    private Integer id;
    private String name;
    private LocalDate startDate;
    private Integer parentId;
}

package ro.agilehub.javacourse.designpatterns.observer.parent;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ParentObject {

    private Integer id;
    private String name;
    private LocalDate startDate;
}

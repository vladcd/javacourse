package ro.agilehub.javacourse.designpatterns.command;

public sealed interface Operation permits Multiplication, Division {

    default boolean isValid() {
        return true;
    }

    double run();
}

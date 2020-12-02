package ro.agilehub.javacourse.designpatterns.command;

@FunctionalInterface
public interface FunctionalOperation {

    default boolean isValid() {
        return true;
    }

    double run();
}

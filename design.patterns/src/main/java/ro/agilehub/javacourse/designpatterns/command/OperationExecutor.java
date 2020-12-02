package ro.agilehub.javacourse.designpatterns.command;

public class OperationExecutor {

    double executeOperation(Operation operation) {
        if (operation.isValid()) {
            return operation.run();
        }
        throw new IllegalArgumentException("The operation was invalid. Please check the log for details");
    }

    double executeFunctionalOperation(FunctionalOperation functionalOperation) {
        if (functionalOperation.isValid()) {
            return functionalOperation.run();
        }
        throw new IllegalArgumentException("The operation was invalid. Please check the log for details");
    }
}

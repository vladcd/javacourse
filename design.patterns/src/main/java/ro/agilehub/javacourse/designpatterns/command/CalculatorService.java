package ro.agilehub.javacourse.designpatterns.command;

import lombok.extern.java.Log;

@Log
public class CalculatorService {

    private enum AllowedOperation {
        MULTIPLICATION, DIVISION
    }

    public double runOperation(double operand1, double operand2, AllowedOperation allowedOperation) {
        return switch (allowedOperation) {
            case MULTIPLICATION -> operand1 * operand2;
            case DIVISION -> {
                if (operand2 == 0) {
                    log.info("Can't divide by 0");
                    throw new IllegalArgumentException();
                }
                yield operand1 / operand2;
            }
        };
    }

    public static void main(String[] args) {

        var calculatorService = new CalculatorService();
        var multiplicationResult = calculatorService.runOperation(12, 11, AllowedOperation.MULTIPLICATION);
        System.out.println(multiplicationResult);

        var operationExecutor = new OperationExecutor();
        operationExecutor.executeOperation(new Multiplication(12, 11));

        operationExecutor.executeFunctionalOperation(() -> 11 * 12);

        Thread thread = new Thread(() -> System.out.println("Hello world"));
        thread.start();
    }

    // TODO 1: what happens if you need to add a new operation?
    // TODO 2: what happens if an operation has 1 operand? what happens if it has 3?
    // TODO 3: how to implement it in a functional way
}

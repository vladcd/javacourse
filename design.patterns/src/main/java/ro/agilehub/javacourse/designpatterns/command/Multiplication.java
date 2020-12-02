package ro.agilehub.javacourse.designpatterns.command;

public record Multiplication(double operand1, double operand2) implements Operation {

    public double run() {
        return operand1 * operand2;
    }

}

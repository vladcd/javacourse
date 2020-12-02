package ro.agilehub.javacourse.designpatterns.command;

import lombok.extern.java.Log;

@Log
public record Division(double operand1, double operand2) implements Operation {

    @Override
    public boolean isValid() {
        if (operand2 == 0) {
            log.info("Can't divide by 0");
            return false;
        }
        return true;
    }

    public double run() {
        return operand1 / operand2;
    }

}

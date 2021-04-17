package ir.shayandaneshvar.util;

import ir.shayandaneshvar.aop.Loggable;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public Double add(Double a, Double b) {
        return a + b;
    }

    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) {
        return add(a, -b);
    }

    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Loggable
    public Double yield(Double a, Double b, Operation op) {
        if (op.equals(Operation.ADD)) {
            return add(a, b);
        }
        return subtract(a, b);
    }

    public Integer yield(Integer a, Integer b, Operation op) {
        if (op.equals(Operation.ADD)) {
            return add(a, b);
        }
        return subtract(a, b);
    }

    public enum Operation {
        ADD, SUBTRACT, NONE;

        public static Operation getOperation(String ops) {
            if (ops.equals("+")) {
                return ADD;
            } else if (ops.equals("-")) {
                return SUBTRACT;
            }
            return NONE;
        }
    }
}

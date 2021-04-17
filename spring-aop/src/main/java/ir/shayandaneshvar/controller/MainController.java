package ir.shayandaneshvar.controller;

import ir.shayandaneshvar.util.Calculator;
import ir.shayandaneshvar.util.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MainController {

    private final Scanner scanner;
    private final Calculator calculator;

    @Autowired
    public MainController(Scanner scanner, Calculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Triple<? extends Number, Calculator.Operation, ? extends Number> input = readInput();
            if (input.getFirst() instanceof Double) {
                System.out.println(calculator.yield((Double) input.getFirst(), (Double) input.getThird(), input.getSecond()));
            } else {
                System.out.println(calculator.yield((Integer) input.getFirst(), (Integer) input.getThird(), input.getSecond()));
            }
        }
    }

    public Triple<? extends Number, Calculator.Operation, ? extends Number> readInput() {
        String[] strings = scanner.nextLine().split(" ");
        Number first;
        Number second;
        if (strings[0].contains(".")) {
            first = Double.parseDouble(strings[0]);
            second = Double.parseDouble(strings[2]);
        } else {
            first = Integer.parseInt(strings[0]);
            second = Integer.parseInt(strings[2]);
        }
        Calculator.Operation ops = Calculator.Operation.getOperation(strings[1]);
        return new Triple<>(first, ops, second);
    }
}

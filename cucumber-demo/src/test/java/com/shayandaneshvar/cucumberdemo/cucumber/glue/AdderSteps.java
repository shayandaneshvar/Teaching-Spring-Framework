package com.shayandaneshvar.cucumberdemo.cucumber.glue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class AdderSteps {
    private Integer firstNumber;
    private Integer secondNumber;


    @Given("I have the following inputs {int} and {int}")
    public void givenIhaveTheFollowingInputs(Integer firstNumber, Integer secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Then("I give them to the adder and expect {int}")
    public void thenIShouldGetTheSum(Integer sum) {
        Assertions.assertThat(sum).isEqualTo(firstNumber + secondNumber);
    }
}

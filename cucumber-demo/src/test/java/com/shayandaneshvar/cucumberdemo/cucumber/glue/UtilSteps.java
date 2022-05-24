package com.shayandaneshvar.cucumberdemo.cucumber.glue;

import com.shayandaneshvar.cucumberdemo.model.User;
import com.shayandaneshvar.cucumberdemo.util.MyUtil;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UtilSteps {

    private final List<User> actualUsers = new ArrayList<>();

    @Before
    public void refresh() {
        actualUsers.clear();
    }

// DataTable can be used directly if you are looking for extra pain!
    @Given("I have the following users")
    public void givenTheFollowingUsers(final List<User> users) {
        actualUsers.addAll(users);
    }

    @When("^I reverse their text$")
    public void whenTheUsersAreReversed() {
        actualUsers.forEach(MyUtil::reverseUserText);
    }

    @Then("I want their reversed to be equal the following")
    public void thenTheirSomeTextShouldBeReversed(List<String> someTexts) {
        IntStream.range(0, actualUsers.size())
                .forEach(index -> Assertions
                        .assertThat(actualUsers.get(index).getSomeText())
                        .isEqualTo(someTexts.get(index)));
    }


}

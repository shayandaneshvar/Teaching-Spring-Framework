package ir.shayandaneshvar.cucumberjunit5demo.cucumber.step;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ir.shayandaneshvar.cucumberjunit5demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonSteps {
    private final PersonRepository repository;

    //this method executes after every scenario
    @After
    public void cleanUp() {
        log.info(">>> cleaning up after scenario!");
        repository.deleteAll();
    }

    //this method executes after every step
    @AfterStep
    public void afterStep() {
        log.info(">>> AfterStep!");
        //placeholder for after step logic
    }

    //this method executes before every scenario
    @Before
    public void before() {
        log.info(">>> Before scenario!");
        //placeholder for before scenario logic
    }

    //this method executes before every step
    @BeforeStep
    public void beforeStep() {
        log.info(">>> BeforeStep!");
        //placeholder for before step logic
    }

    @When("user saves the user")
    public void userSavesTheUser() {
        System.out.println("He");
    }

    @Then("user gets persisted")
    public void userGetsPersisted() {
        System.out.println("sds");
    }
}

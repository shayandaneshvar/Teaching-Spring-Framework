package ir.shayandaneshvar.cucumberjunit5demo;

import ir.shayandaneshvar.cucumberjunit5demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CucumberJunit5DemoApplicationTests {

    private final PersonService personService;

    @Test
    void contextLoads() {
        System.out.println("In SpringBootTest Context Load Test");
    }

}

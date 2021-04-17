package ir.shayandaneshvar;

import ir.shayandaneshvar.controller.MainController;
import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
//@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED) // private methods
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "ir.shayandaneshvar")
public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        ctx.getBean(MainController.class).run();
    }
}

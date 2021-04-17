import ir.shayandaneshvar.i18n_spring_core_bean.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringBeansTest {

    @Test
    public void beanFactoryAndApplicationContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student s = (Student) ctx.getBean("myStudent");
        System.out.println(s);
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        s = (Student) beanFactory.getBean("myStudent");
        System.out.println(s);

        B b = ctx.getBean("b", B.class);
        System.out.println(b.getA());

        C c = ctx.getBean("c",C.class);
        System.out.println(c.getD());
    }

    @Test
    public void testAnnotation(){
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(Config.class);
        C c2 = ctx2.getBean("c",C.class);
        System.out.println(c2.getD());
    }

    @Test
    public void testServiceAndJDBCInjection(){
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(Config.class);
        StudentService studentService = ctx2.getBean(StudentService.class);
        System.out.println(studentService.getConnection());
    }
}

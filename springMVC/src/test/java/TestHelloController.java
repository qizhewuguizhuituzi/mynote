import com.zcb.controller.HelloController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloController {
    @Test
    public void testHello(){
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("springmvc-servlet.xml");
        HelloController helloController = context.getBean("helloController", HelloController.class);
        System.out.println(helloController);
    }
}

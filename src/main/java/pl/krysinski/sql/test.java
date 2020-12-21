package pl.krysinski.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.krysinski.sql.service.UserServiceImpl;
import pl.krysinski.sql.utils.aspect.AfterAspect;
import pl.krysinski.sql.utils.aspect.BeforeAspect;
import pl.krysinski.sql.utils.aspect.LogExecutionTime;

import java.io.IOException;

@Component
public class test {

    private UserServiceImpl userService;

    @Autowired
    public test(UserServiceImpl userService) {
        this.userService = userService;
    }


    @EventListener(ApplicationReadyEvent.class)
    @LogExecutionTime
    public void testSave() throws IOException {
        userService.addAll();
    }

//    @EventListener(ApplicationReadyEvent.class)
//    @AfterAspect
//    @BeforeAspect
//    public void testRead() {
//        userService.findAll();
////        userService.findAll().forEach(System.out::println);
//    }
}

package pl.krysinski.sql.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.krysinski.sql.service.UserServiceImpl;
import pl.krysinski.sql.utils.aspect.LogExecutionTime;

import java.io.IOException;

@Component
public class App {

    private UserServiceImpl userService;

    @Autowired
    public App(UserServiceImpl userService) {
        this.userService = userService;
    }


    @EventListener(ApplicationReadyEvent.class)
    @LogExecutionTime
    public void saveToDb() throws IOException {
        userService.addAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    @LogExecutionTime
    public void readFromDb() {
//        userService.findAll();
        userService.findAll().forEach(System.out::println);
    }
}

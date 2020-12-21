package pl.krysinski.sql.service;

import pl.krysinski.sql.model.User;
import java.io.IOException;
import java.util.List;


public interface UserService {

    void addAll() throws IOException;
    List<User> findAll();

}

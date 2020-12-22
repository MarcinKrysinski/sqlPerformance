package pl.krysinski.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krysinski.sql.model.Gender;
import pl.krysinski.sql.model.User;
import pl.krysinski.sql.repository.UserRepo;
import pl.krysinski.sql.utils.Reader;

import java.io.IOException;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private Reader csvReader;


    @Autowired
    public UserServiceImpl(UserRepo userRepo, Reader csvReader) {
        this.userRepo = userRepo;
        this.csvReader = csvReader;
    }


    @Override
    public List<User> addAll() throws IOException {
        List<User> userList = csvReader.readData();
         return userRepo.saveAll(userList);
    }


    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }


}

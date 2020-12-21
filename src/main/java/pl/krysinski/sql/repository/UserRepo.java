package pl.krysinski.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krysinski.sql.model.User;



@Repository
public interface UserRepo extends JpaRepository <User, String> {

}

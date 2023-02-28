package peaksoft.demo.repository;

import peaksoft.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Long> {
    User findUserByEmail(String email);

}

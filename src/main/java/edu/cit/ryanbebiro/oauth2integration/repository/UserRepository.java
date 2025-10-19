package edu.cit.ryanbebiro.oauth2integration.repository;

import edu.cit.ryanbebiro.oauth2integration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

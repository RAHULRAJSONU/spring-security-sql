package edu.silvertech.project.springsecuritysql.repository;

import edu.silvertech.project.springsecuritysql.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository  extends JpaRepository<Users, UUID> {
    Optional<Users> findByName(String username);
}

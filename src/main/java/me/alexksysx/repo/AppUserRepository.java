package me.alexksysx.repo;

import me.alexksysx.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsernameAndPassword(String username, String password);
    Optional<AppUser> findByToken(String token);
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
}

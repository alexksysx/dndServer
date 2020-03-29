package me.alexksysx.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import me.alexksysx.model.AppUser;
import me.alexksysx.repo.AppUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean
    TimedAspect timedAspect(MeterRegistry meterRegistry) {
        return new TimedAspect(meterRegistry);
    }

    @Bean
    String imageDirectory() {
        return "./img/";
    }

    @Bean
    boolean createUser(AppUserRepository appUserRepository) {
        AppUser user = new AppUser();
        ArrayList<String> roles = new ArrayList<>();
        roles.add("USER");
        roles.add("ADMIN");
        user.setUsername("alx");
        user.setPassword(bCryptEncoder().encode("alx"));
        user.setRoles(roles);
        user.setEmail("test@test.ru");
        appUserRepository.save(user);
        return true;
    }

    @Bean
    public BCryptPasswordEncoder bCryptEncoder() {
        return new BCryptPasswordEncoder();
    }
}

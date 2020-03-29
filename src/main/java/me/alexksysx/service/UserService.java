package me.alexksysx.service;

import me.alexksysx.dto.AppUserDto;
import me.alexksysx.dto.TokenDto;
import me.alexksysx.model.AppUser;
import me.alexksysx.repo.AppUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    AppUserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(BCryptPasswordEncoder bCryptEncoder) {
        this.bCryptPasswordEncoder = bCryptEncoder;
    }

    public AppUser createNewUser(String username, String password, ArrayList<String> roles, String email) {
        AppUser appUser = new AppUser(null, username, bCryptPasswordEncoder.encode(password), email, null, roles);
        return userRepository.save(appUser);
    }

    public AppUser createNewUser(AppUserDto appUserDto) {
        appUserDto.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword()));
        return userRepository.save(getAppUserFromDto(appUserDto));
    }

    public TokenDto login(String username, String password) {
        Optional<AppUser> userOptional=userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            if(bCryptPasswordEncoder.matches(password, userOptional.get().getPassword())) {
                AppUser user = userOptional.get();
                String token = user.getToken();
                if (StringUtils.isEmpty(token)) {
                    token = UUID.randomUUID().toString();
                    user.setToken(token);
                    userRepository.save(user);
                }
                return new TokenDto(token);
            }
        }
        return new TokenDto("-");
    }

    public Optional<User> findByToken(String token) {
        Optional<AppUser> userOptional = userRepository.findByToken(token);
        if (userOptional.isPresent()) {
            AppUser appUser = userOptional.get();
            User user = new User(appUser.getUsername(), appUser.getPassword(), true, true, true, true,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getRoles().toString().replace("[","").replace("]","")));
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public AppUser findById(Long id) {
        Optional<AppUser> user = userRepository.findById(id);
        return user.orElse(null);
    }

    private AppUser getAppUserFromDto(AppUserDto appUserDto) {
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserDto, appUser, "token");
        return appUser;
    }

}

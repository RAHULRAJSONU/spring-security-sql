package edu.silvertech.project.springsecuritysql.service;

import edu.silvertech.project.springsecuritysql.domain.CustomUserDetails;
import edu.silvertech.project.springsecuritysql.domain.Users;
import edu.silvertech.project.springsecuritysql.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findByName(username);
        optionalUsers.orElseThrow(()-> new UsernameNotFoundException("User not found!"));
        return optionalUsers.map(CustomUserDetails::new).get();
    }
}

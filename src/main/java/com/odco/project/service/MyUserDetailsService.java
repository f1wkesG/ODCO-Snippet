package com.odco.project.service;

import com.odco.project.entity.MyUserDetails;
import com.odco.project.entity.User;
import com.odco.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + userName));
        return user.map(MyUserDetails::new).get();
    }
}

package com.dgmf.service.impl;

import com.dgmf.entity.User;
import com.dgmf.repository.UserRepository;
import com.dgmf.service.AdminService;
import com.dgmf.utils.enums.UserRole;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @PostConstruct // https://www.baeldung.com/spring-postconstruct-predestroy
    public void createAdminAccount() {
        System.out.println("Stack Trace - AdminServiceImpl - " +
                "@PostConstruct - createAdminAccount()");

        User adminAccount = userRepository.findByUserRole(UserRole.ROLE_ADMIN);

        if(adminAccount == null) {
            User admin = User.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .username("johndoe")
                    .email("johndoe@gmail.com")
                    .password(passwordEncoder.encode("admin"))
                    .userRole(UserRole.ROLE_ADMIN)
                    .build();

            userRepository.save(admin);
        }
    }
}

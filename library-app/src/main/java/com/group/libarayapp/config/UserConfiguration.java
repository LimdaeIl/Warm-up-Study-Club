package com.group.libarayapp.config;

import com.group.libarayapp.domain.user.UserRepository;
import com.group.libarayapp.repository.user.UserJdbcRepository;
import com.group.libarayapp.service.user.UserServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserConfiguration {

//    @Bean
//    public UserJdbcRepository userRepository(JdbcTemplate jdbcTemplate) {
//        return new UserJdbcRepository(jdbcTemplate);
//    }

//    @Bean
//    public UserServiceV2 userService(UserRepository userRepository) {
//        return new UserServiceV2(userRepository);
//    }



}
package com.grantserve.grantserve1.util;

import com.grantserve.grantserve1.dto.UserDto;
import com.grantserve.grantserve1.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ClassUtilSeparator {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User userRegisterUtil(UserDto userDto) {
        User user = new User();
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setPhone(userDto.phone());
        user.setRole(userDto.role());
        user.setPassword(encoder.encode(userDto.password()));
        user.setStatus("ACTIVE");
        return user;
    }

    public static void userUpdateUtil(UserDto userDto, User existingUser) {
        existingUser.setName(userDto.name());
        existingUser.setEmail(userDto.email());
        existingUser.setPhone(userDto.phone());
        existingUser.setRole(userDto.role());
        // Assuming password is not updated here, or handle separately
    }
}

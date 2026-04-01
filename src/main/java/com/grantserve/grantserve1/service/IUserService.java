package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.UserDto;
import com.grantserve.grantserve1.entity.User;
import com.grantserve.grantserve1.exception.UserException;
import com.grantserve.grantserve1.projection.IUserProjection;

import java.util.List;

public interface IUserService {

    public String registerUser(UserDto user) throws UserException;

    IUserProjection fetchUser(Long userId);

    public String updateUser(Long userId,UserDto userDto) throws UserException;

    String UserLoginValidation(User user);
}

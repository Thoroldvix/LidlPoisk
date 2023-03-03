package com.example.lidlpoisk.service;

import com.example.lidlpoisk.model.dto.UserCreateDto;
import com.example.lidlpoisk.model.dto.UserEditDto;
import com.example.lidlpoisk.model.entities.User;

public interface UserService {

    void delete(Long id);

    void create(UserCreateDto userCreateDto);

    boolean edit(Long id, UserEditDto userUpdateDto);

    User findByUsername(String username);


}

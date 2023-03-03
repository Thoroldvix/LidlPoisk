package com.example.lidlpoisk.service;

import com.example.lidlpoisk.model.dto.user.UserCreateEditDto;
import com.example.lidlpoisk.model.entities.User;

public interface UserService {

    void delete(Long id);

    void create(UserCreateEditDto userCreateDto);

    boolean edit(Long id, UserCreateEditDto userUpdateDto);

    User findByUsername(String username);


}

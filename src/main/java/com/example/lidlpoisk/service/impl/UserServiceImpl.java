package com.example.lidlpoisk.service.impl;

import com.example.lidlpoisk.model.dto.UserCreateDto;
import com.example.lidlpoisk.model.dto.UserEditDto;
import com.example.lidlpoisk.model.entities.User;
import com.example.lidlpoisk.repository.UserRepository;
import com.example.lidlpoisk.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void create(UserCreateDto userCreateDto) {
        userRepository.save(modelMapper.map(userCreateDto, User.class));
    }

    @Override
    public boolean edit(Long id, UserEditDto userEditDto) {
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}

package com.leverx.peoplebase.user.service;

import com.leverx.peoplebase.user.entity.User;
import com.leverx.peoplebase.user.entity.dto.UserInputDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(long id);

    User save(UserInputDto user);

    void delete(long id);
}
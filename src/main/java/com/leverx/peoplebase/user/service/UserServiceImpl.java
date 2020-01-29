package com.leverx.peoplebase.user.service;

import com.leverx.peoplebase.user.entity.User;
import com.leverx.peoplebase.user.entity.dto.UserInputDto;
import com.leverx.peoplebase.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(UserInputDto userInputDto) {
        User user = new User();
        user.setDateOfBirth(userInputDto.getDateOfBirth());
        user.setName(userInputDto.getName());
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        Optional<User> userOpt = userRepository.findById(id);
        userOpt.ifPresent(user -> userRepository.delete(user));
    }
}
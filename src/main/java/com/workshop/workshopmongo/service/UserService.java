package com.workshop.workshopmongo.service;

import com.workshop.workshopmongo.domain.User;
import com.workshop.workshopmongo.dto.UserDto;
import com.workshop.workshopmongo.exception.ObjectNotFoundException;
import com.workshop.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public UserDto findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return new UserDto(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")));
    }

    public UserDto insertUser(UserDto user) {
        User userDomain = new User( user.getName(), user.getEmail());
        return new UserDto(userRepository.insert(userDomain));
    }

    public void deleteUser(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public UserDto updateUser(UserDto userDto){
        Optional<User> newObj = userRepository.findById(userDto.getId());
        User user = userRepository.save(updateData(newObj.get(), new User(userDto.getName(), userDto.getEmail())));
        return new UserDto(user);
    }

    public User updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        return newObj;
    }




}

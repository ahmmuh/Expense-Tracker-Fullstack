package com.example.expensetrackerbackendapi.services;

import com.example.expensetrackerbackendapi.DTO.ResponseUserDTO;
import com.example.expensetrackerbackendapi.exceptions.UserNotFoundException;
import com.example.expensetrackerbackendapi.models.User;
import com.example.expensetrackerbackendapi.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDTO addUser(User user) {
        Optional<User> existsByEmail = userRepository.existsByEmail(user.getEmail());
        if (existsByEmail.isPresent()) {
           existsByEmail.orElseThrow(() -> new UserNotFoundException("This email already exists"));
        }
        User savedUser = userRepository.save(user);
       return mapUserDTO(savedUser);
    }

    public List<ResponseUserDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapUserDTO)
                .collect(Collectors.toList());
    }

    public ResponseUserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return mapUserDTO(user);
    }
    public ResponseUserDTO updateUser(Long id,User updatedUser) {
        User savedUser = userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapUserDTO(savedUser);

    }
    public void deleteUserById(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);

        }

    }

//Pagination
    public Page<User> findAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }
//Sorting
    public List<User> sortAllUsers(Sort sort){
        return userRepository.findAll(sort);
    }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User email not found"));
    }
    private ResponseUserDTO mapUserDTO(User user) {
        return new ResponseUserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}

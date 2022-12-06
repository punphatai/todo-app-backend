package com.dev.todoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public List<User> getUser(){
        return this.userRepository.findAll();
    }


    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken.");
        }
        System.out.println(user);
        this.userRepository.save(user);
    }

    public void deleteUser(int userId) {
        boolean exits = this.userRepository.existsById(userId);
        if(!exits) {
            throw new IllegalStateException(
              "User with id " + userId + " does not exits."
            );
        }
        this.userRepository.deleteById(userId);
    }
}

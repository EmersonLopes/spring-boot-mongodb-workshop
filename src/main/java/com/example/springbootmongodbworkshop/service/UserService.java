package com.example.springbootmongodbworkshop.service;
import com.example.springbootmongodbworkshop.domain.User;
import com.example.springbootmongodbworkshop.dto.UserDTO;
import com.example.springbootmongodbworkshop.exception.ObjectNotFoundException;
import com.example.springbootmongodbworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findbyId(String id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new ObjectNotFoundException("Usuário não encontrado");

        }

        return user.get();
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        User newUser = this.findbyId(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public void delete(String id){

        User user = this.findbyId(id);
        userRepository.delete(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}

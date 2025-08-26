package com.collabtask.service;

import com.collabtask.model.User;
import com.collabtask.model.Team;
import com.collabtask.model.Role;
import com.collabtask.repository.UserRepository;
import com.collabtask.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        user.setTeam(userDetails.getTeam());
        return userRepository.save(user);
    }
    
    public List<User> getUsersByTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow();
        return team.getMembers().stream().toList();
    }
}

package com.aaa.projekt.services;

import com.aaa.projekt.Repository.RoleRepository;
import com.aaa.projekt.Repository.UsersRepository;
import com.aaa.projekt.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private static final int PAGE_SIZE = 1;
    private final UsersRepository userRepository;
    private final RoleRepository roleRepository;

//    @Cacheable(cacheNames = "Users", key = "#page")
    public List<Users> getUsers(int page) {
        return userRepository.findAllUsers(PageRequest.of(page, PAGE_SIZE));
    }

    public Long countUsers() {
        return userRepository.count();
    }

    public void deleteSingleUser(long id) {
        userRepository.deleteById(id);
    }
}

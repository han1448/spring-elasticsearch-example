package com.oppalove.elasticsearch;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        Assert.notNull(user, "user must be not null.");
        Assert.notNull(user.getId(), "user.id must be not null.");
        return userRepository.save(user);
    }

    @Override
    public User findUser(Long id) {
        Assert.notNull(id, "id must be not null.");
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        Iterable<User> iterable = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        iterable.forEach(userList::add);
        return userList;
    }

    @Override
    public void deleteUser(Long id) {
        Assert.notNull(id, "id must be not null.");
        userRepository.deleteById(id);
    }


}

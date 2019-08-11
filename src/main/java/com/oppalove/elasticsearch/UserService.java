package com.oppalove.elasticsearch;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User findUser(Long id);

    List<User> findAll();

    void deleteUser(Long id);
}

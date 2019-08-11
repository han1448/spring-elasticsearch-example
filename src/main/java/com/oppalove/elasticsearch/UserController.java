package com.oppalove.elasticsearch;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * <pre>
     *
     * curl -XPOST http://localhost:8080/travel/add -H'Content-Type: application/json' -d '
     * {
     *  "id": 1,
     *  "name": "HanSeunghyeon",
     *  "country": "KOR",
     *  "age": 41
     * }'
     * </pre>
     *
     * @param user
     * @return User
     */
    @RequestMapping(value = "/travel/add", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * <pre>
     *     curl -XGET http://localhost:8080/travel/user/1
     * </pre>
     *
     * @param id
     * @return User
     */
    @RequestMapping(value = "/travel/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {
        return userService.findUser(id);
    }

    /**
     * <pre>
     *     curl -XDELETE http://localhost:8080/travel/user/1
     * </pre>
     *
     * @param id
     */
    @RequestMapping(value = "/travel/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    /**
     * <pre>
     *     curl -XGET http://localhost:8080/travel/all
     * </pre>
     *
     * @return List of user
     */
    @RequestMapping(value = "/travel/all", method = RequestMethod.GET)
    public List<User> getUser() {
        Iterable<User> iterable = userService.findAll();
        List<User> userList = new ArrayList<>();
        iterable.forEach(userList::add);
        return userList;
    }
}

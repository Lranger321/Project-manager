package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.repository.UserRepository;
import com.simbirsoft.projectManager.rest.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.rest.dto.response.UserResponse;
import com.simbirsoft.projectManager.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Тесты UserService
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User testingUser = new User();
        testingUser.setFullName("Babur");
        testingUser.setEmail("babur@google.com");
        testingUser.setPassword("password");
        userRepository.save(testingUser);
    }

    @After
    public void clearUp() {
        if (userRepository.findByFullName("Babur").isPresent()) {
            userRepository.delete(userRepository.findByFullName("Babur").get());
        }
    }

    @Test
    public void testFindByEmail() {
        UserResponse userResponse = userService.findByEmail("babur@google.com");
        Assert.assertEquals("Babur", userResponse.getName());
    }

    @Test
    public void testRegisterUser() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFullName("Eugenio");
        userRegisterRequest.setPassword("111");
        userRegisterRequest.setRepeatPassword("111");
        userRegisterRequest.setEmail("eugenio@goole.com");

        UUID testedUuid = userService.registerUser(userRegisterRequest);
        UserResponse userResponse = userService.getUserById(testedUuid.toString());
        Assert.assertEquals("Eugenio", userResponse.getName());
        userService.deleteUser(testedUuid.toString());
    }

    @Test
    public void testUpdateUser() {
        UserResponse userResponse = userService.findByEmail("babur@google.com");
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFullName("Eugenio");
        userRegisterRequest.setPassword("111");
        userRegisterRequest.setRepeatPassword("111");
        userRegisterRequest.setEmail("eugenio@goole.com");
        userService.updateUser(userResponse.getId().toString(), userRegisterRequest);

        UUID testedUuid = userResponse.getId();
        userResponse = userService.getUserById(testedUuid.toString());
        Assert.assertEquals("Eugenio", userResponse.getName());
        userService.deleteUser(testedUuid.toString());
    }
}

package com.simbirsoft.projectManager;

import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 * Тесты UserRepository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        assertThat(userRepository).isNotNull();
    }

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

    /**
     * Тест добавления пользователя
     */
    @Test
    public void testAddUser() throws Exception {
        if (userRepository.findByFullName("Babur").isPresent()) {
            Assert.assertEquals("Babur", userRepository.findByFullName("Babur").get().getFullName());
        } else {
            fail("Не удалость получит ползователя \"Babur\" из БД");
        }
    }

    /**
     * Тест удаления пользователя
     * @throws Exception
     */
    @Test
    public void testDelUser() throws Exception {
        clearUp();
        Assert.assertTrue(!userRepository.findByFullName("Babur").isPresent());
    }

    /**
     * Тест обновления данных пользователе
     */
    @Test
    public void testSetUser() throws Exception {
        if (userRepository.findByFullName("Babur").isPresent()) {
            User testUser = new User();
            testUser = userRepository.findByFullName("Babur").get();
            testUser.setEmail("babur@yandex.com");
            userRepository.save(testUser);
            Assert.assertEquals("babur@yandex.com", userRepository.findByFullName("Babur").get().getEmail());
        } else {
            fail("Не удалость получит ползователя \"Babur\" из БД");
        }
    }

    /**
     * Тест получения данных о пользователе
     */
    @Test
    public void testGetUser() throws Exception {
        if (userRepository.findByFullName("Babur").isPresent()) {
            Assert.assertEquals("Babur", userRepository.findByFullName("Babur").get().getFullName());
        } else {
            fail("Не удалость получит ползователя \"Babur\" из БД");
        }
    }
}

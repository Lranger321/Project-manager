package com.simbirsoft.projectManager.repository;

import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.entity.TaskStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.fail;

/**
 * Тесты TaskRepository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Before
    public void setUp() {
        Task testingUser = new Task();
        testingUser.setName("Babur");
        testingUser.setDescription("Lorem Ipsum");
        testingUser.setStatus(TaskStatus.IN_PROGRESS);
        taskRepository.save(testingUser);
    }

    @After
    public void clearUp() {
        if (taskRepository.findByName("Babur").isPresent()) {
            taskRepository.delete(taskRepository.findByName("Babur").get());
        }
    }

    /**
     * Тест добавления задачи
     */
    @Test
    public void testAddTask() throws Exception {
        if (taskRepository.findByName("Babur").isPresent()) {
            Assert.assertEquals("Babur", taskRepository.findByName("Babur").get().getName());
        } else {
            fail("Не удалость получить задачу \"Babur\" из БД");
        }
    }

    /**
     * Тест удаления задачи
     */
    @Test
    public void testDelTask() throws Exception {
        clearUp();
        Assert.assertTrue(!taskRepository.findByName("Babur").isPresent());
    }

    /**
     * Тест обновления данных задачи
     */
    @Test
    public void testSetTask() throws Exception {
        if (taskRepository.findByName("Babur").isPresent()) {
            Task testTask = taskRepository.findByName("Babur").get();
            testTask.setStatus(TaskStatus.DONE);
            taskRepository.save(testTask);
            Assert.assertEquals(TaskStatus.DONE, taskRepository.findByName("Babur").get().getStatus());
        } else {
            fail("Не удалость получить задачу \"Babur\" из БД");
        }
    }

    /**
     * Тест получения данных о задаче
     */
    @Test
    public void testGetTask() throws Exception {
        if (taskRepository.findByName("Babur").isPresent()) {
            Assert.assertEquals("Babur", taskRepository.findByName("Babur").get().getName());
        } else {
            fail("Не удалость получить задачу \"Babur\" из БД");
        }
    }
}


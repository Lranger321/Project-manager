package com.simbirsoft.projectManager.repository;

import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.ProjectStatus;
import com.simbirsoft.projectManager.entity.RoleEnum;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.fail;

/**
 * Тесты ProjectRepository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Before
    public void setUp() {
        Project testingUser = new Project();
        testingUser.setName("Babur");
        testingUser.setStatus(ProjectStatus.IN_PROGRESS);
        projectRepository.save(testingUser);
    }

    @After
    public void clearUp() {
        if (projectRepository.findByName("Babur").isPresent()) {
            projectRepository.delete(projectRepository.findByName("Babur").get());
        }
    }

    /**
     * Тест добавления проекта
     */
    @Test
    public void testAddProject() throws Exception {
        if (projectRepository.findByName("Babur").isPresent()) {
            Assert.assertEquals("Babur", projectRepository.findByName("Babur").get().getName());
        } else {
            fail("Не удалость получить проект \"Babur\" из БД");
        }
    }

    /**
     * Тест удаления проекта
     */
    @Test
    public void testDelProject() throws Exception {
        clearUp();
        Assert.assertTrue(!projectRepository.findByName("Babur").isPresent());
    }

    /**
     * Тест обновления данных проекта
     */
    @Test
    public void testSetProject() throws Exception {
        if (projectRepository.findByName("Babur").isPresent()) {
            Project testProject = projectRepository.findByName("Babur").get();
            testProject.setStatus(ProjectStatus.DONE);
            projectRepository.save(testProject);
            Assert.assertEquals(ProjectStatus.DONE, projectRepository.findByName("Babur").get().getStatus());
        } else {
            fail("Не удалость получить проект \"Babur\" из БД");
        }
    }

    /**
     * Тест получения данных о проекте
     */
    @Test
    public void testGetProject() throws Exception {
        if (projectRepository.findByName("Babur").isPresent()) {
            Assert.assertEquals("Babur", projectRepository.findByName("Babur").get().getName());
        } else {
            fail("Не удалость получить проект \"Babur\" из БД");
        }
    }

    @Test
    public void testGetUserRoleInProject() throws Exception {

        UUID userId = UUID.fromString("749c62bc-f960-4511-961f-ffa98c655cec");
        UUID ProjectId = UUID.fromString("749c62bc-f960-4511-961f-ffa98c655cef");
        Optional<String> testRole = projectRepository.findUserRoleInProject(userId, ProjectId);
        if (testRole.isPresent()) {
            System.out.println("Role is " + testRole.get());
        }

        RoleEnum adminRole = RoleEnum.ADMIN;
        RoleEnum userRole = RoleEnum.USER;

        System.out.println(adminRole);
        System.out.println(userRole);
    }
}

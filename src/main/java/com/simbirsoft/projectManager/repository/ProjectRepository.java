package com.simbirsoft.projectManager.repository;

import com.simbirsoft.projectManager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    /**
     * Найти проект по имени
     *
     * @param name - имя проекта
     * @return опционально проект
     */
    @Query("SELECT u FROM Project u WHERE u.name = :name")
    Optional<Project> findByName(@Param("name") String name);

    /**
     * Найти проект по имени
     *
     * @param userId    - ид пользователя
     * @param projectId - ид проекта
     * @return опционально строку с наименование роли
     */
    @Query(value = "select project_to_user.role from project_to_user inner join project on " +
            " project_to_user.project_id = project.id where project_id = :projectId " +
            " and project_to_user.user_id = :userId ", nativeQuery = true)
    Optional<String> findUserRoleInProject(@Param("userId") UUID userId, @Param("projectId") UUID projectId);
}

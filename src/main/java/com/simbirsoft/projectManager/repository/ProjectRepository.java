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
     * Находит проект по имени
     *
     * @param name - имя пользователя
     * @return опционально пользователь
     */
    @Query("SELECT u FROM Project u WHERE u.name = :name")
    Optional<Project> findByName(@Param("name") String name);

}

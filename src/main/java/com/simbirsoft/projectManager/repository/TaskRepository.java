package com.simbirsoft.projectManager.repository;

import com.simbirsoft.projectManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    @Query(value = "SELECT count(*) FROM task WHERE project_id = :project_id AND status != 'DONE' "
            ,nativeQuery = true)
    long countNotDoneTask(@Param("project_id") UUID projectId);

}

package com.simbirsoft.projectManager.repository;

import com.simbirsoft.projectManager.entity.ProjectToUser;
import com.simbirsoft.projectManager.entity.ProjectToUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectToUserRepository extends JpaRepository<ProjectToUser, ProjectToUserId> {

    @Override
    Optional<ProjectToUser> findById(ProjectToUserId projectToUserId);
}
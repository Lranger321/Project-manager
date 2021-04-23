package com.simbirsoft.projectManager.repository;

import com.simbirsoft.projectManager.entity.ProjectToUserEntity;
import com.simbirsoft.projectManager.entity.ProjectToUserID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectToUserRepository extends JpaRepository<ProjectToUserEntity, ProjectToUserID> {

}

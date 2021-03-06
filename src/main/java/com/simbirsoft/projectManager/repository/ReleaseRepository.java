package com.simbirsoft.projectManager.repository;

import com.simbirsoft.projectManager.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, UUID> {

}

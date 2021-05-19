package com.simbirsoft.projectManager.repository;

import com.simbirsoft.projectManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

//    /**
//     * Находит пользователя по id
//     *
//     * @param uuid - id пользователя
//     * @return опционально пользователь
//     */
//    Optional<User> findById(UUID uuid);

    /**
     * Находит пользователя по имени
     *
     * @param fullName - имя пользователя
     * @return опционально пользователь
     */
    @Query("SELECT u FROM User u WHERE u.fullName = :fullName")
    Optional<User> findByFullName(@Param("fullName") String fullName);

    Optional<User> findByEmail(String eMail);
}

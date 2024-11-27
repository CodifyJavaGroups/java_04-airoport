package com.example.demo.repositories;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select u from UserEntity u where u.login = :login")
    UserEntity findByLogin(@Param("login") String login);

    @Modifying
    @Query("delete from UserEntity u where u.id = :id")
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query("delete from UserEntity u where u.login = :login")
    void deleteByLogin(@Param("login") String login);

}

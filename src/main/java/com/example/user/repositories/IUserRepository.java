package com.example.user.repositories;

import com.example.user.entities.User;
import com.example.user.entities.projections.IUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT users.id AS userId, users.full_name AS userFullName, "+
            "users.email AS userEmail, users.password AS userPassword FROM users " +
            "WHERE users.email = :email AND users.password = :password ;", nativeQuery = true)
    IUserProjection findUserByEmailAndPassword(String email, String password);
}

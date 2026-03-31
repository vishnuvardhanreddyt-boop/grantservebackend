package com.grantserve.grantserve1.repository;

import com.grantserve.grantserve1.entity.User;
import com.grantserve.grantserve1.projection.IUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("SELECT u.userID AS userID, " +
            "u.name AS name, " +
            "u.email AS email, " +
            "u.role AS role, " +
            "u.status AS status " +
            "FROM User u WHERE u.userID = :userId")
    Optional<IUserProjection> findByUserID(@Param("userId") Long userId);

    Optional<User> findByuserID(Long userID);

    Optional<User> findByEmail(String email);
}

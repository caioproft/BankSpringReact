package com.invillia.bankSpringAndReact.repository;

import com.invillia.bankSpringAndReact.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

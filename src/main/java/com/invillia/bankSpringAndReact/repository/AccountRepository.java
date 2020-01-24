package com.invillia.bankSpringAndReact.repository;

import com.invillia.bankSpringAndReact.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long > {

    boolean existsAccountByUserId(Long id);
}

package com.project.Bank.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Bank.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//In Generics, we use Entity name and Id type
public interface BankRepository extends JpaRepository<Bank,Long> {
    Bank findByAccountNo(Long accountNo);

    List<Bank> findByAccountHolderName(String accountHolderName);

}

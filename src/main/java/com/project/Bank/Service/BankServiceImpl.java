package com.project.Bank.Service;

import com.project.Bank.Entity.Bank;
import com.project.Bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository repo;

    @Override
    public Bank addBankAccountdetails(Bank b)
    {
        Bank presentAccount = repo.findByAccountNo(b.getAccountNo());
        if(presentAccount!=null){
            throw new RuntimeException("Account is Already Exists");
        }
                else {
            return repo.save(b);
        }
    }

    @Override
    public List<Bank> getAccountDetails() {
        return repo.findAll();
    }

}


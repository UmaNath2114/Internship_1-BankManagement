package com.project.Bank.Service;

import com.project.Bank.Entity.Bank;
import com.project.Bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository repo;
}
//   // public Bank addAcoountHolderdetails(Bank b) {
//   //      return repo.save(b);
//    }
//}

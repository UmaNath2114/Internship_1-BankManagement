package com.project.Bank.Service;

import com.project.Bank.Entity.Bank;
import com.project.Bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        List<Bank> presentAccount = repo.findAll();
        if(presentAccount.isEmpty()){
            throw new RuntimeException("No Accounts activate");
        }
        else{
            return presentAccount;
        }
    }

    @Override
    public  Boolean delectAccountDetails(Long id) {
        Optional<Bank> presentAccount = repo.findById(id);
        if (presentAccount.isEmpty()){
            throw new RuntimeException("No Account Found to Delete");
        }
        else {
            repo.deleteById(id);
            return true;
        }
    }

    @Override
    public Bank updateAccountDetails(Long id, Bank b) {
        Optional<Bank> presentAccount = repo.findById(id);
        if(presentAccount.isEmpty()){
            throw new RuntimeException("No AccountDetails for Update");
        }
        else {
            Bank needToUpdate = presentAccount.get();
            needToUpdate.setAccountHolderName(b.getAccountHolderName());
            needToUpdate.setEmail(b.getEmail());
            needToUpdate.setAccountHolderPhnNo(b.getAccountHolderPhnNo());
            needToUpdate.setAccountNo(b.getAccountNo());
            return repo.save(needToUpdate);
        }

    }


    @Override
    public List<Bank> getCustomerDetails(String accountHolderName) {
        List<Bank> presentAccount = repo.findByAccountHolderName(accountHolderName);
        if (presentAccount.isEmpty()) {
            throw new RuntimeException("Customer Details Not Found");
        } else {
            return presentAccount;
        }
    }
}


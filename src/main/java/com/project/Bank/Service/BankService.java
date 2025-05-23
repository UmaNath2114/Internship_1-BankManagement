package com.project.Bank.Service;

import com.project.Bank.Entity.Bank;

import java.util.List;

public interface BankService {
    Bank addBankAccountdetails(Bank b);

    List<Bank> getAccountDetails();

    Boolean delectAccountDetails(Long id);

    Bank updateAccountDetails(Long id, Bank b);

    List<Bank> getCustomerDetails(String accountHolderName);
}
package com.project.Bank.Controller;

import com.project.Bank.Entity.Bank;
import com.project.Bank.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/api/bank")
@RestController
public class BankController {
  @Autowired
  private BankService service;

  @GetMapping("/")
    public String testApi(){
      return "This is Test Api";
  }

  @PostMapping("/add-accountholder")
  public HashMap<String,Object> addBankAccount(@RequestBody Bank b){
      HashMap<String,Object> response = new HashMap<String,Object>();
      try{
          Bank  addedBankAccount =service.addBankAccountdetails(b);
          response.put("message","Data Added Successfully");
          response.put("AccountHolder",addedBankAccount);
          return response;
      } catch(Exception e){
          response.put("error","error occured");
          return response;
      }
  }
  @GetMapping("/get-accountholder")
    public HashMap<String,Object> getAccountHolder(){
    HashMap<String,Object> response = new HashMap<String,Object>();
    try{
       List<Bank> presentAccount =service.getAccountDetails();
       response.put("message","Account Fetched Successfully");
       response.put("Account details",presentAccount);
       return response;
    }
    catch (Exception e){
      response.put("error","error occured");
              return response;
    }
  }

}

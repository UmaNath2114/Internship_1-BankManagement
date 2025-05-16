package com.project.Bank.Controller;

import com.project.Bank.Entity.Bank;
import com.project.Bank.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequestMapping("/api/bank")
@RestController
public class BankController {
  @Autowired
  private BankService service;

  @PostMapping("/add-accountholder")
  public HashMap<String,Object> addAccountHolder(@RequestBody Bank b){
      HashMap<String,Object> response = new HashMap<String,Object>();
      try{
          Bank  addedAccountHolder =service.addAcoountHolderdetails(b);
          response.put("message","Data Added Successfully");
          response.put("AccountHolder",addedAccountHolder);
          return response;
      } catch(Exception e){
          response.put("error","error occured");
          return response;
      }

  }

}

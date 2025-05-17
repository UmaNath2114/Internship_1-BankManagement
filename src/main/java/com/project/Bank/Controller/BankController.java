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
    private final String emailId = "umanath2114@gmail.com";
    private final  String password = "uma2114";

  @Autowired
  private BankService service;

  @GetMapping("/")
    public String testApi(){
      return "This is Test Api";
  }

  @PostMapping("/add-account")
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
  @GetMapping("/get-account")
    public HashMap<String,Object> getAccountHolder(){
    HashMap<String,Object> response = new HashMap<String,Object>();
    try{
       List<Bank> presentAccount =service.getAccountDetails();
       response.put("message","Account Fetched Successfully");
       response.put("Account details",presentAccount);
       return response;
    }
    catch (Exception e){
      response.put("error",e.getMessage());
              return response;
    }
  }
  @DeleteMapping("/delete-account")
    public HashMap<String,Object> delectAcccount(@RequestParam  Long id){
      HashMap<String,Object> response = new HashMap<String,Object>();
      try{
          Boolean presentAccount = service.delectAccountDetails(id);
          response.put("message","Delete Account Successfully");
          response.put("Delete Account",presentAccount);
          return response;
      }
      catch(Exception e){
          response.put("Error",e.getMessage());
          return response;
      }
  }
  @PutMapping("/update-account")
   public HashMap<String,Object> updateAccount(@RequestParam Long id,@RequestBody Bank b){
  HashMap<String,Object> response=new HashMap<String,Object>();
  try{
      Bank presentAccount=service.updateAccountDetails(id,b);
     response.put("message","Account Updated Successfully");
      response.put("Update Account",presentAccount);
      return response;
  }
  catch (Exception e){
      response.put("error",e.getMessage());
      return response;
  }
  }
  @GetMapping("/get-customer")
    public HashMap<String,Object> getCustomerDetails(@RequestParam String accountHolderName){
      HashMap<String,Object> response = new HashMap<String, Object>();
      try{
           List<Bank> presentAccount=service.getCustomerDetails(accountHolderName);
           response.put("message","Customer Details Fetched Successfully");
           response.put("Customer",presentAccount);
           return response;
      }
      catch(Exception e){
          response.put("Error",e.getMessage());
          return response;
      }
  }
@PostMapping("/login")
    public HashMap<String,Object > login(@RequestParam String email,@RequestParam String pass){
      HashMap<String,Object> response =new HashMap<String,Object>();
      try{
          if(email.equals(emailId) && pass.equals(password) ){
              response.put("message","umanath logged in successfully");
              return response;
          }
          else{
              response.put("msg","Invalid details please try again");
              return response;
          }
      }
      catch(Exception e){
          response.put("error","Error occured");
          return response;
      }
}
}

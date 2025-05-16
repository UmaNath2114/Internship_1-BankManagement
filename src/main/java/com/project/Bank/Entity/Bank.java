package com.project.Bank.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
  @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String accountHolderName;
  private Long accountNo;
  private Long accountHolderPhnNo;
  private String email;
}

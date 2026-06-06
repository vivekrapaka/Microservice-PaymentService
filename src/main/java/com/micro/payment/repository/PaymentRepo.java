package com.micro.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.payment.entity.PaymentDetails;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentDetails, String>{

	PaymentDetails findByUserIdAndPassword(String userId, String password);
}

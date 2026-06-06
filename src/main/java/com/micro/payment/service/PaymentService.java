package com.micro.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.payment.dto.NetBankingUserDetailsDto;
import com.micro.payment.dto.PaymentLoginDetailsDto;
import com.micro.payment.entity.PaymentDetails;
import com.micro.payment.repository.PaymentRepo;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepo payrepo;
	

	public String netbankingRegister(NetBankingUserDetailsDto dto) {
		try {
			PaymentDetails pay = PaymentDetails.builder()
					.name(dto.getName())
					.password(dto.getPassword())
					.avilableBalance(dto.getAvilableBalance())
					.userId(dto.getUserId())
					.build();
			payrepo.save(pay);
			return "NetBankingUser has register succesfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "something went wrong";
			
		}
	}

	public String netbankingLogin(PaymentLoginDetailsDto dto) {

		PaymentDetails pay = payrepo.findByUserIdAndPassword(dto.getUserId(), dto.getPassword());

		if (pay != null) {
			return "Net Banking Login succesful";
		} else {
			return "Net banking login failed";
		}

	}

}

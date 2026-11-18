package com.micro.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.payment.dto.NetBankingUserDetailsDto;
import com.micro.payment.dto.PaymentLoginDetailsDto;
import com.micro.payment.service.PaymentService;

@RestController("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;

	@PostMapping("/netbanking/register")
	public String netBankingRegister(@RequestBody NetBankingUserDetailsDto dto) {

		return  paymentService.netbankingRegister(dto);
	}

	@PostMapping("/netbanking/login")
	public String netBankingLogin(@RequestBody PaymentLoginDetailsDto dto) {

		return paymentService.netbankingLogin(dto);
	}

	@PostMapping("/netbanking/details")
	public String netBanking(@RequestBody PaymentLoginDetailsDto dto) {

		return paymentService.netbankingLogin(dto);
	}
	
	@GetMapping("/banking/options")
	public List<String> bankingOptionAvilable() {
		return List.of("CC", "DC", "netbanking", "UPI");
	}
}


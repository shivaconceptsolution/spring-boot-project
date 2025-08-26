package com.springbootpractice.firstspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootpractice.firstspringboot.models.Reg;
import com.springbootpractice.firstspringboot.repository.RegRepository;
@Service
public class RegServiceImpl implements RegService {
	@Autowired
    private RegRepository regRepo;
	@Autowired
	private  PasswordEncoder passwordEncoder;
	@Override
	public Reg saveReg(Reg r) {
	//	r.setPassword(passwordEncoder.encode(r.getPassword()));
		r.setPassword(r.getPassword());
		return regRepo.save(r);
	}
	@Override
	public boolean verifyReg(Reg r) {
		// TODO Auto-generated method stub
		return regRepo.findByUsername(r.getUsername())
                .map(user -> r.getPassword().equals(user.getPassword())) // plain text compare
                .orElse(false);
	}

}

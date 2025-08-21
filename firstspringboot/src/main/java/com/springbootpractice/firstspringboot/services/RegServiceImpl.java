package com.springbootpractice.firstspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootpractice.firstspringboot.models.Reg;
import com.springbootpractice.firstspringboot.repository.RegRepository;
@Service
public class RegServiceImpl implements RegService {
	@Autowired
    private RegRepository regRepo;
	@Override
	public Reg saveReg(Reg r) {
		return regRepo.save(r);
	}
	@Override
	public boolean verifyReg(Reg r) {
		// TODO Auto-generated method stub
		
		return  regRepo.findByUsernameAndPassword(r.getUsername(),r.getPassword()).isPresent();
	}

}

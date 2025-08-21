package com.springbootpractice.firstspringboot.services;

import org.springframework.stereotype.Service;

import com.springbootpractice.firstspringboot.models.Reg;

public interface RegService {
	Reg saveReg(Reg r);
	boolean verifyReg(Reg r);
}

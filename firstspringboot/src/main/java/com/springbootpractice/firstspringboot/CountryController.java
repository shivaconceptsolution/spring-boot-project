package com.springbootpractice.firstspringboot;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.model.Country;



@RestController
@RequestMapping("/api/countries")
public class CountryController {
	private List<Country> countryList = List.of(
	        new Country("India", "New Delhi", 1400000000),
	        new Country("USA", "Washington, D.C.", 331000000),
	        new Country("Japan", "Tokyo", 126000000)
	    );
	
	@GetMapping
    public List<Country> getAllCountries() {
        return countryList;
    }
}

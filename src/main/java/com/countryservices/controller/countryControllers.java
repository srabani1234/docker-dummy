package com.countryservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservices.beans.Country;
import com.countryservices.services.countryService;

@RestController
public class countryControllers {
	
	//countryService CountryService = new countryService();
	
@Autowired
public countryService CountryService;

//This is for hashMap
//end point - http://localhost:9009/getcountries
@RequestMapping("/getcountries")
@GetMapping("/getcountries")
public List getCountries() {
	
	return CountryService.getAllCountries();
	
}


//end point - http://localhost:8080/getcountries/1
@GetMapping("/getcountries/{id}")
public Country getCountrieById(@PathVariable(value="id") int id) {
	
	return CountryService.getCountryByID(id);
	
}
	
//end point - http://localhost:8080/getcountries/countryname?name=india
@GetMapping("/getcountries/countryname")
public Country getCountrieByName(@RequestParam(value="name") String countryName) {
	
	return CountryService.getCountryByName(countryName);
	
}

////end point - http://localhost:8080/addcountry
/* Request body -post
 * {
 * "countryName":"Italy",
 * "countryCapital":"Rome"
 * }
 * */

@PostMapping("/addcountry")
/*the @RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the 
 * inbound HttpRequest body onto a Java object. Spring automatically deserializes the JSON into a Java type,*/

public Country AddCountrys(@RequestBody Country country) {
	
	return CountryService.addCountry(country);
	
}
/* end point - http://localhost:8080/updatecountry
 * Request Body -put
 * {
 * "id":4,
 * "countryName": "Japan",
 * "Capital":"Tokyo",
 * }
 * */

@PutMapping("/updatecountry")
public Country UpdateCountry(@RequestBody Country country) {
	
	return CountryService.updateCounty(country);
	
}
//end point - http://localhost:8080/deletecountry/4

@DeleteMapping("/deletecountry/{id}")
public addResponse DeleteCountry(@PathVariable (value ="id")int id) {
	
	return CountryService.deleteCountry(id);	
}


}

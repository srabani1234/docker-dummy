package com.countryservices.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservices.beans.Country;
import com.countryservices.controller.addResponse;

@Component
@Service
public class countryService {


	// This code is for hashMap
	static HashMap<Integer,Country> countryIdMap;
	
	public countryService() {
		countryIdMap = new HashMap<Integer,Country>();
		
		Country indiaCountry = new Country(1, "India","Delhi");
		Country usaCountry = new Country(2,"USA","Washington");
		Country ukCountry = new Country(3, "UK","London");
		
		countryIdMap.put(1, indiaCountry);
		countryIdMap.put(2, usaCountry);
		countryIdMap.put(3, ukCountry);
		
		System.out.println(countryIdMap);
	
	}
		
		public List getAllCountries() {
			List countries = new ArrayList(countryIdMap.values());
			return countries;
		}
		
		public Country getCountryByID(int id) {
		
			Country country = countryIdMap.get(id);
			System.out.println("id:"+country);
			return country;
			
		}
		
	   public Country getCountryByName(String countryName) {
		   
		   Country country =null;
		   
		   for(int i:countryIdMap.keySet()) {
			   if(countryIdMap.get(i).getCountryName().equals(countryName)) {
				   
				   country  = countryIdMap.get(i);
				   
			   }
		   }
		   return country;
	   }
	   
	   public Country addCountry(Country country) {
		   
		   country.setId(getMaxId());
		   countryIdMap.put(country.getId(), country);
		   return country;
		   
	   }
	   
	   public Country updateCounty(Country country) {
		   
		   if(country.getId()>0) {
			   countryIdMap.put(country.getId(), country);
		   }
		   return country;
	   }
	   public addResponse deleteCountry(int id) {
		   
		   countryIdMap.remove(id);
		   addResponse res = new addResponse();
		   res.setMsg("Country deleted !!!");
		   res.setId(id);
		   
		   return res;
		   
	   }
	  public static int getMaxId() {
		  int max=0;
		  for(int id:countryIdMap.keySet()) {
			  if(max<=id) {
				  max=id;
			  }
		  }
		  return max+1;
		  
	  }
	  

}

package com.costco.patient.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.costco.patient.dao.PatientDao;
import com.costco.patient.model.Patient;

@RestController
@RequestMapping("/api/v1")
public class PatientController {
	
	@Autowired
	PatientDao patientDao;

	// @RequestMapping(value = "/test", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String getStr() {
		System.out.println("In getStr3");
		return "Hello Spr";
	} // http://localhost:8080/costco/api/v1
	
	@RequestMapping(method = RequestMethod.POST)
	public int createPatient(@RequestBody Patient patient) {
		System.out.println("In getStr2");
		patient.setDateOfBirth(new Date());
		int row = patientDao.insertEmployee(patient);
		return row;
	} // http://localhost:8080/costco/api/v1

}

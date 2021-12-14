package com.costco.patient.dao;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.costco.patient.model.Patient;

@Component
public class PatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertEmployee(Patient patient) {
		String insertSql = "INSERT INTO patients(first_name, last_name, date_of_birth) VALUES (?, ?, ?)";

		// define query arguments
		Object[] params = new Object[] { patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth() };

		// define SQL types of the arguments
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DATE };

		// execute insert query to insert the data
		// return number of row / rows processed by the executed query
		int row = jdbcTemplate.update(insertSql, params, types);
		System.out.println(row + " row inserted.");
		return row;
	}

}

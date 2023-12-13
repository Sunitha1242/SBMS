package net.javaguides.employeeservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.service1.EmployeeService;

@AllArgsConstructor
@RestController
@RequestMapping("employee")
public class EmployeeController {

	EmployeeService employeeService;

	// Build save Employee Rest API

	@PostMapping("/post")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		
		EmployeeDto savedemployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedemployee, HttpStatus.CREATED);

	}
	@GetMapping("/all")
	public List<Employee> getAllEmployee()
	{
		List<Employee> savedemployee = employeeService.getAllDetaisl();
		return savedemployee;
	}
	
	// Build get Employees Rest API
	@GetMapping("get/{id}")
	public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeid) {
		APIResponseDto apiResponseDto = employeeService.findEmployeeById(employeeid);

		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);

	}

}


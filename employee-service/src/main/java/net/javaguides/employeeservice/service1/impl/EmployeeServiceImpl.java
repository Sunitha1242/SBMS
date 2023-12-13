package net.javaguides.employeeservice.service1.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service1.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;
//	RestTemplate restTemplate;
	WebClient webClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail(), employeeDto.getDepartmentCode());

		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
				savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode());

		return savedEmployeeDto;
	}

	@Override
	public APIResponseDto findEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).get();
//		ResponseEntity<DepartmentDto> reponseEntity = restTemplate.getForEntity(
//				"http://localhost:8085/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//		DepartmentDto departmentDto = reponseEntity.getBody();

		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8085/api/departments/" + employee.getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();

//		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

		EmployeeDto savedemployeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(),
				employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());

		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(savedemployeeDto);
		apiResponseDto.setDepartment(departmentDto);

		return apiResponseDto;
	}

	@Override
	public List<Employee> getAllDetaisl() {

		List<Employee> employee = employeeRepository.findAll();
		return employee;
	}

}

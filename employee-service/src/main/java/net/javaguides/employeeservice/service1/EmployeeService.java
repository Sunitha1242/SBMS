package net.javaguides.employeeservice.service1;

import java.util.List;

import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;

public interface EmployeeService {
EmployeeDto saveEmployee(EmployeeDto employeeDto);

APIResponseDto findEmployeeById(Long id);

List<Employee> getAllDetaisl();
}

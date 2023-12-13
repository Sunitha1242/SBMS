package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	// DepartmentDto findByDepartmentId(Long id);
	DepartmentDto getDepartmentByCode(String code);
}

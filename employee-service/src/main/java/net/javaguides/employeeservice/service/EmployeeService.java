package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
    void removeEmployeeById(Long id);
    APIResponseDto updateEmployee(EmployeeDto employeeDto);
}

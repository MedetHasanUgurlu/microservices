package net.javaguides.employeeservice.controller;

import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

public interface EmployeeController {
    ResponseEntity<APIResponseDto> getEmployeeById(Long id);
    ResponseEntity createEmployee(EmployeeDto employeeDto);
    ResponseEntity<List<EmployeeDto>> getEmployees();
}

package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface DepartmentService {
    void createDepartment(DepartmentDto departmentDto);
    ResponseEntity<DepartmentDto> getDepartmentById(Long id);
    ResponseEntity<DepartmentDto> getDepartmentByCode(String code);
    ResponseEntity<DepartmentDto> updateDepartment(Optional<DepartmentDto> departmentDto);
    void deleteDepartment(Long id);
}

package net.javaguides.departmentservice.controller;


import net.javaguides.departmentservice.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentController {

    ResponseEntity createDepartment(DepartmentDto departmentDto);
    ResponseEntity<DepartmentDto> getDepartmentById(Long id);
    ResponseEntity<DepartmentDto> getDepartmentByCode(String code);
    ResponseEntity<DepartmentDto> updateDepartment(Optional<DepartmentDto> departmentDto);
    ResponseEntity deleteDepartment(Long id);
    ResponseEntity<List<DepartmentDto>> getAllDepartment();


}

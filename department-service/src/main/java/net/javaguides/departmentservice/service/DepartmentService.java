package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long id);
    DepartmentDto getDepartmentByCode(String code);
   DepartmentDto updateDepartment(Optional<DepartmentDto> departmentDto);
    void deleteDepartment(Long id);
    List<DepartmentDto> getAllDepartments();
}

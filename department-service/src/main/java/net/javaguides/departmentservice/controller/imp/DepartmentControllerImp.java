package net.javaguides.departmentservice.controller.imp;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.javaguides.departmentservice.constants.URLPathConstant;
import net.javaguides.departmentservice.controller.DepartmentController;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(URLPathConstant.DEPARTMENT_HOME)
public class DepartmentControllerImp implements DepartmentController {
    private final DepartmentService service;

    @Override
    @PostMapping
    public ResponseEntity createDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
        service.createDepartment(departmentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getDepartmentById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping("/param")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@RequestParam String code) {
        return new ResponseEntity<>(service.getDepartmentByCode(code),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody Optional<DepartmentDto> departmentDto) {
        return new ResponseEntity<>(service.updateDepartment(departmentDto),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartment(@PathVariable Long id) {
        service.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
        return new ResponseEntity<>(service.getAllDepartments(),HttpStatus.OK);
    }
}

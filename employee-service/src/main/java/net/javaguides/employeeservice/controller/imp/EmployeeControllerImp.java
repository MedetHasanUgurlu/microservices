package net.javaguides.employeeservice.controller.imp;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.constants.URLPathConstant;
import net.javaguides.employeeservice.controller.EmployeeController;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(URLPathConstant.HOME)
public class EmployeeControllerImp implements EmployeeController {
    private final EmployeeService service;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        service.createEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return new ResponseEntity<>(service.getAllEmployee(),HttpStatus.OK);
    }


}

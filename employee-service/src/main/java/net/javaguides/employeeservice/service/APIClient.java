package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.constants.URLPathConstant;
import net.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = URLPathConstant.DEPARTMENT_SERVICE, value = "DEPARTMENT-SERVICE")

public interface APIClient {

    @GetMapping("/param")
    DepartmentDto getDepartmentByCode(@RequestParam String code);

}

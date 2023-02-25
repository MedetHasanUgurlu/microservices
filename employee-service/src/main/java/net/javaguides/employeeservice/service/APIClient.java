package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.constants.URLPathConstant;
import net.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



//For Load Balancing we should use service name.
//@FeignClient("DEPARTMENT-SERVICE")
//@FeignClient(url = URLPathConstant.DEPARTMENT_SERVICE1, value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DE")
public interface APIClient {

    @GetMapping("/param")
    DepartmentDto getDepartmentByCode(@RequestParam String code);

}

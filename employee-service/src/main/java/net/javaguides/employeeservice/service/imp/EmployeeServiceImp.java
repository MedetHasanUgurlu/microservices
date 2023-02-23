package net.javaguides.employeeservice.service.imp;

import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.constants.ErrorConstants;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exceptions.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import net.javaguides.employeeservice.util.ModelMapperBean;
import net.javaguides.employeeservice.util.RestTemplateBean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private final ModelMapperBean modelMapperBean;
    private final EmployeeRepository repository;
    //private final RestTemplateBean restTemplateBean;
    private final APIClient apiClient;

    EmployeeDto entityToDto(Employee employee){
        return modelMapperBean.getModelMapper().map(employee,EmployeeDto.class);
    }
    Employee dtoToEntity(EmployeeDto employeeDto){
        return modelMapperBean.getModelMapper().map(employeeDto,Employee.class);
    }

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        repository.save(dtoToEntity(employeeDto));
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Employee not found.");
        }
        EmployeeDto employeeDto = entityToDto(repository.findById(id).get());
        //ResponseEntity<DepartmentDto> responseEntity = restTemplateBean.getRestTemplate().getForEntity("http://localhost:8080/department/param?code="+employeeDto.getDepartmentCode(),DepartmentDto.class );
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employeeDto.getDepartmentCode());
        return APIResponseDto.builder()
                .departmentDto(departmentDto)
                .employeeDto(employeeDto)
                .build();
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> list = new ArrayList<>();
        repository.findAll().forEach(employee ->
             list.add(entityToDto(employee))
        );
        return list;
    }

    @Override
    public void removeEmployeeById(Long id) {

    }

    @Override
    public APIResponseDto updateEmployee(EmployeeDto employeeDto) {
        return null;
    }
}

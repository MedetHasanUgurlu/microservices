package net.javaguides.departmentservice.service.imp;

import lombok.RequiredArgsConstructor;
import net.javaguides.departmentservice.constants.ExceptionConstant;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exceptions.exception.IDNullException;
import net.javaguides.departmentservice.exceptions.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import net.javaguides.departmentservice.util.ModelMapperBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository repository;
    private final ModelMapperBean modelMapperBean;

    public Department dtoToEntity(DepartmentDto departmentDto){
        return modelMapperBean.getModelMapper().map(departmentDto,Department.class);
    }
    public DepartmentDto entityToDto(Department department){
        return modelMapperBean.getModelMapper().map(department,DepartmentDto.class);
    }


    @Override
    public void createDepartment(DepartmentDto departmentDto) {
        repository.save(dtoToEntity(departmentDto));
    }

    @Override
    public ResponseEntity<DepartmentDto> getDepartmentById(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("A","B",id);
        }
        return new ResponseEntity<>(entityToDto(repository.findById(id).get()), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<DepartmentDto> getDepartmentByCode(String code) {
        if(repository.findByDepartmentCode(code).isEmpty()){
            throw new ResourceNotFoundException("","",0L);
        }
        return new ResponseEntity<>(entityToDto(repository.findByDepartmentCode(code).get()),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DepartmentDto> updateDepartment(Optional<DepartmentDto> departmentDto) {
        if(departmentDto.isEmpty()){
            throw new IDNullException(ExceptionConstant.ID_MUST_NOT_BE_NULL);
        }
        repository.save(dtoToEntity(departmentDto.get()));
        return new ResponseEntity<>(departmentDto.get(),HttpStatus.OK);
    }

    @Override
    public void deleteDepartment(Long id) {
        if(id == null){
            throw new IDNullException(ExceptionConstant.ID_MUST_NOT_BE_NULL);
        }
        repository.deleteById(id);
    }
}

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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public DepartmentDto getDepartmentById(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("A","B",id);
            }


        return entityToDto(repository.findById(id).get());

    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        if(repository.findByDepartmentCode(code).isEmpty()){
            throw new ResourceNotFoundException("","",0L);
        }
        return entityToDto(repository.findByDepartmentCode(code).get());
    }

    @Override
    public DepartmentDto updateDepartment(Optional<DepartmentDto> departmentDto) {

        if(departmentDto.get().getId() == null){
            throw new IDNullException(ExceptionConstant.ID_MUST_NOT_BE_NULL);
        }
        Department department = dtoToEntity(departmentDto.get());
        repository.save(department);
        return departmentDto.get();
    }

    @Override
    public void deleteDepartment(Long id) {
        if(id == null){
            throw new IDNullException(ExceptionConstant.ID_MUST_NOT_BE_NULL);
        }
        repository.deleteById(id);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> dtoList = new ArrayList<>();
        repository.findAll().forEach(department -> {
            dtoList.add(entityToDto(department));
        });
        return dtoList;
    }
}

package net.javaguides.departmentservice.util;

import lombok.RequiredArgsConstructor;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ReadyData implements CommandLineRunner {

    private final DepartmentRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Department department = new Department().builder()
                .departmentName("Information Technology")
                .departmentCode("IT-1")
                .departmentDescription("Information Technology department stands for innovating life.")
                .build();
        Department department2 = new Department().builder()
                .departmentName("Information Technology")
                .departmentCode("IT-2")
                .departmentDescription("Information Technology department stands for innovating life.")
                .build();
        Department department3 = new Department().builder()
                .departmentName("Sales Department")
                .departmentCode("SA-1")
                .departmentDescription("Information Technology department stands for innovating life.")
                .build();
        Department department4 = new Department().builder()
                .departmentName("Information Technology")
                .departmentCode("SA-2")
                .departmentDescription("Information Technology department stands for innovating life.")
                .build();

        repository.save(department);
        repository.save(department2);
        repository.save(department3);
        repository.save(department4);
    }
}

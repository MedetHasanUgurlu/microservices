package net.javaguides.employeeservice.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDto {
    private Long id;
    private String departmentName;
    private String departmentCode;
    private String departmentDescription;
}

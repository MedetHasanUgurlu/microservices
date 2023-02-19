package net.javaguides.departmentservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import net.javaguides.departmentservice.constants.ExceptionConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private Long id;
    @NotNull(message = ExceptionConstant.DEPARTMENT_NAME_NOT_BE_NULL)
    @NotEmpty(message = ExceptionConstant.DEPARTMENT_NAME_NOT_BE_EMPTY)
    private String departmentName;
    @NotNull(message = ExceptionConstant.DEPARTMENT_CODE_NOT_BE_NULL)
    @NotEmpty(message = ExceptionConstant.DEPARTMENT_CODE_NOT_BE_EMPTY)
    private String departmentCode;
    private String departmentDescription;

}

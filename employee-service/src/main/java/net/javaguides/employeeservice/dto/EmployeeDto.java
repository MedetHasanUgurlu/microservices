package net.javaguides.employeeservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import net.javaguides.employeeservice.constants.ErrorConstants;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Long id;
    @NotNull(message = ErrorConstants.FIRSTNAME_NOT_NULL)
    @NotEmpty(message = ErrorConstants.FIRSTNAME_NOT_EMPTY)
    private String firstName;
    @NotNull(message = ErrorConstants.LASTNAME_NOT_NULL)
    @NotEmpty(message = ErrorConstants.LASTNAME_NOT_EMPTY)
    private String lastName;
    @NotNull(message = ErrorConstants.EMAIL_NOT_NULL)
    @NotEmpty(message = ErrorConstants.EMAIL_NOT_EMPTY)
    private String email;
    @NotNull(message = ErrorConstants.DEPARTMENT_CODE_NOT_NULL)
    @NotEmpty(message = ErrorConstants.DEPARTMENT_CODE_NOT_EMPTY)
    private String departmentCode;
}

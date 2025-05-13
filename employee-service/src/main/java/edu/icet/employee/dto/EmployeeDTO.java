package edu.icet.employee.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String address;
    private LocalDateTime joinDate;
    private Integer departmentId;
}

package edu.icet.employee.service;


import edu.icet.department.dto.DepartmentDTO;
import edu.icet.department.exception.DepartmentNotFoundException;
import edu.icet.employee.client.DepartmentClient;
import edu.icet.employee.dto.EmployeeDTO;
import edu.icet.employee.entity.EmployeeEntity;
import edu.icet.employee.repository.EmployeeRepo;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {

private final EmployeeRepo employeeRepo;
private final DepartmentClient departmentClient;

    public EmployeeDTO create(EmployeeDTO employee){
        Integer departmentId = employee.getDepartmentId();
        try{
            return mapToDTO(employeeRepo.save(
                    EmployeeEntity.builder()
                            .name(employee.getName())
                            .departmentId(Objects.requireNonNull(departmentClient.getById(departmentId).getBody()).getId())
                            .address(employee.getAddress())
                            .build()
            ));
        }catch (FeignException e){
             throw new DepartmentNotFoundException("INVALID ID");
        }
    }

    private EmployeeDTO mapToDTO(EmployeeEntity employeeEntity){
        return EmployeeDTO.builder()
                .id(employeeEntity.getId())
                .name(employeeEntity.getName())
                .departmentId(employeeEntity.getDepartmentId())
                .address(employeeEntity.getAddress())
                .build();
    }



}

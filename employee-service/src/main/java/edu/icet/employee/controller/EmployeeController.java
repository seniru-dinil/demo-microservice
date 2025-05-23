package edu.icet.employee.controller;


import edu.icet.employee.dto.EmployeeDTO;
import edu.icet.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO employee){
       return ResponseEntity.ok(employeeService.create(employee));
    }

}

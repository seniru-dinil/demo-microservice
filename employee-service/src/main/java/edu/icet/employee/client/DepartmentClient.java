package edu.icet.employee.client;


import edu.icet.department.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentClient {
    @GetMapping("/api/department/{id}")
     ResponseEntity<DepartmentDTO> getById(@PathVariable Integer id);

}

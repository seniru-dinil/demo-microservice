package edu.icet.department.controller;


import edu.icet.department.dto.DepartmentDTO;
import edu.icet.department.service.DepartmentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
 private final DepartmentService departmentService;


   @PostMapping
    public ResponseEntity<DepartmentDTO> create(@RequestBody  @Valid DepartmentDTO dto){
       return ResponseEntity.ok(departmentService.create(dto));
   }

   @GetMapping("/{id}")
   public ResponseEntity<DepartmentDTO> getById(@PathVariable Integer id, HttpServletRequest request){
       int port = request.getLocalPort();
       log.info("<<< /api/department >>> Running on port: {}", port);
       return ResponseEntity.ok(departmentService.getById(id));
   }

}

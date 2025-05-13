package edu.icet.department.service;


import edu.icet.department.dto.DepartmentDTO;
import edu.icet.department.entity.DepartmentEntity;
import edu.icet.department.exception.DepartmentNotFoundException;
import edu.icet.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {


    private final DepartmentRepository departmentRepository;


    public DepartmentDTO create(DepartmentDTO department){
        return mapToDTO(departmentRepository.save(DepartmentEntity.builder()
                        .name(department.getName())
                .build()));
    }

    private DepartmentDTO mapToDTO(DepartmentEntity entity) {
        return DepartmentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }


    public DepartmentDTO getById(Integer id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("INVALID ID"));
        return mapToDTO(departmentEntity);
    }
}

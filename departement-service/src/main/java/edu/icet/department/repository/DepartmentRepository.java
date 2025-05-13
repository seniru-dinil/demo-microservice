package edu.icet.department.repository;

import edu.icet.department.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {
}

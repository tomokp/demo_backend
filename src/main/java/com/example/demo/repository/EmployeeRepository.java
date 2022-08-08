package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Modifying
//    @Transactional
//    @Query("delete from EmployeeServiceImpl where u.id in(:integers)")
//    void deleteByIdIn(List<Integer> integers);
}





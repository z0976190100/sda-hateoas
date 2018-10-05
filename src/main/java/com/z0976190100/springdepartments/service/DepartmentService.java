package com.z0976190100.springdepartments.service;

import com.z0976190100.springdepartments.persistence.entity.Department;
import com.z0976190100.springdepartments.persistence.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {


    private DepartmentRepo departmentRepo;

    DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department save(Department department) {
        return departmentRepo.save(department);

    }

    public List<Department> findAll(){
        return departmentRepo.findAll();
    }

    public Optional<Department> findById(Long id){
        return departmentRepo.findById(id);
    }
}

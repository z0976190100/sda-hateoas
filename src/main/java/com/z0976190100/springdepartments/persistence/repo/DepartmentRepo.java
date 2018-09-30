package com.z0976190100.springdepartments.persistence.repo;

import com.z0976190100.springdepartments.persistence.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// @RepositoryRestResource(collectionResourceRel = "facilities", path = "facilities") gives us opportunity to customise
// mappings and rels
public interface DepartmentRepo extends JpaRepository<Department, Long>,
        PagingAndSortingRepository<Department, Long> {

    List<Department> findDepartmentByTitle (String title);
}

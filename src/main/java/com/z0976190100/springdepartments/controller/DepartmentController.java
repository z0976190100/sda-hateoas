package com.z0976190100.springdepartments.controller;

import com.z0976190100.springdepartments.controller.exceptions.DepartmentNotFoundException;
import com.z0976190100.springdepartments.persistence.entity.Department;
import com.z0976190100.springdepartments.persistence.repo.DepartmentRepo;
import com.z0976190100.springdepartments.util.DepartmentResourceAssembler;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "departments/", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
public class DepartmentController {

    private final DepartmentRepo departmentRepo;
    private final DepartmentResourceAssembler departmentResourceAssembler;

    DepartmentController(DepartmentRepo departmentRepo,
                         DepartmentResourceAssembler departmentResourceAssembler) {
        this.departmentRepo = departmentRepo;
        this.departmentResourceAssembler = departmentResourceAssembler;

    }

    @GetMapping("/")
    public Resources<Department> all() {

        List<Resource<Department>> departments = departmentRepo.findAll().stream()
                .map(departmentResourceAssembler::toResource)
                .collect(Collectors.toList());
        return new Resources(departments,
                linkTo(methodOn(DepartmentController.class).all()).withSelfRel()); // example from here http://spring.io/guides/tutorials/rest/
    }


    // QUNG-FUSED:
    @GetMapping("/{id}")
    public Resource<Department> one(@PathVariable Long id) throws DepartmentNotFoundException {

        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
        return departmentResourceAssembler.toResource(department);

    }

    // see: http://spring.io/guides/tutorials/rest/
    @PostMapping("/")
    ResponseEntity<?> newDepartment(@RequestBody Department department) throws URISyntaxException {

        Resource<Department> resource = departmentResourceAssembler
                .toResource(departmentRepo.save(department));

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);

    }


/*
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}*/

}

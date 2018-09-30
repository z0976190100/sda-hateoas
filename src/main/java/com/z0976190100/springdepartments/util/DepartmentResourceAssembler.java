package com.z0976190100.springdepartments.util;

import com.z0976190100.springdepartments.controller.DepartmentController;
import com.z0976190100.springdepartments.controller.exceptions.DepartmentNotFoundException;
import com.z0976190100.springdepartments.persistence.entity.Department;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class DepartmentResourceAssembler implements ResourceAssembler<Department, Resource<Department>> {

    @Override
    public Resource<Department> toResource(Department department){

            return new Resource<Department>(department,
                    linkTo(methodOn(DepartmentController.class).one(department.getId())).withSelfRel(),
                    linkTo(methodOn(DepartmentController.class).all()).withRel("departments"));
            
    }
}



/*



    }
}
*/

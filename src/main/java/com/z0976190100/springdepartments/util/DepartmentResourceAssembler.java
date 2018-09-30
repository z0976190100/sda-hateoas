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
    public Resource<Department> toResource(Department entity){

        try {
            return new Resource<Department>(entity,
                    linkTo(methodOn(DepartmentController.class).one(entity.getId())).withSelfRel(),
                    linkTo(methodOn(DepartmentController.class).all()).withRel("employees"));
        } catch (DepartmentNotFoundException e) {
            e.printStackTrace();
            // Q: null??? are we good here?
            return null;
        }
    }
}



/*



    }
}
*/

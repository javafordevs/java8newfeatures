package com.java4devs.java8features.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java4devs.java8features.dao.EmployeeDao;
import com.java4devs.java8features.model.Employee;

@RestController
public class EmployeeController {
    EmployeeDao dao;

    public EmployeeController(EmployeeDao dao) {
        this.dao = dao;
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployees(){
        System.out.println("printing");
       return  dao.getEmployees();
    }
    

}

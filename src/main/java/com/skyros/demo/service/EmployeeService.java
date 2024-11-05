package com.skyros.demo.service;

import com.google.gson.Gson;
import com.skyros.demo.vo.Employee;
import com.skyros.demo.repo.EmployeeRepo;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Setter
@Getter
@Log4j2
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    Gson gson;

    public void addEmployee(String emp) {
        Employee employee = getGson().fromJson(emp, Employee.class);
        log.info(employee.getEmail());
    }

}

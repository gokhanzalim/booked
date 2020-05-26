package com.microservices.common.employeeservice.service;

import com.microservices.common.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(String id,EmployeeDto employeeDto);

    Boolean delete(String id);

    EmployeeDto getById(String id);

    List<EmployeeDto> getAll();

}

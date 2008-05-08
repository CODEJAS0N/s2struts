package org.seasar.struts.examples.web.employee;

import java.util.List;

import org.seasar.struts.examples.dto.EmployeeDto;
import org.seasar.struts.examples.dto.EmployeeSearchDto;
import org.seasar.struts.examples.entity.Department;
import org.seasar.struts.examples.entity.Employee;

public interface EmployeeLogic {

    List<Employee> getEmployees(EmployeeSearchDto dto);

    EmployeeDto getEmployeeDto(int empno);

    List<Department> getAllDepartments();

    void insert(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);

}

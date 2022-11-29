package spring.hibernate.dao;

import spring.hibernate.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void insert(Employee employee);

    void update(Employee employee);

    void delete(long id);

    Employee getEmployeeById(long id);

    List<Employee>getAllEmployees();

}

package EmployeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EmployeeManagement.Model.Employee;

@Repository
public interface employeeRepository extends JpaRepository<Employee, Long> {

}

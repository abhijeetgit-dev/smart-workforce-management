package workforce_management.service;

import workforce_management.entity.Employee;
import workforce_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // Add Employee
    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }

    public Employee updateEmployee(int id, Employee emp) {
        Employee existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(emp.getName());
            existing.setEmail(emp.getEmail());
            existing.setDepartment(emp.getDepartment());
            existing.setSalary(emp.getSalary());
            return repo.save(existing);
        }
        return null;
    }

    public List<Employee> searchByName(String name) {
        return repo.findByName(name);
    }
}
package workforce_management.controller;

import workforce_management.entity.Employee;
import workforce_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee add(@Valid @RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @Valid @RequestBody Employee emp) {
        return service.updateEmployee(id, emp);
    }

    @GetMapping("/search/{name}")
    public List<Employee> search(@PathVariable String name) {
        return service.searchByName(name);
    }
}

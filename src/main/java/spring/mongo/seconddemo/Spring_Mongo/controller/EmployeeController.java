package spring.mongo.seconddemo.Spring_Mongo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.mongo.seconddemo.Spring_Mongo.dto.EmployeeRequestDTO;
import spring.mongo.seconddemo.Spring_Mongo.dto.EmployeeResponseDTO;
import spring.mongo.seconddemo.Spring_Mongo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public EmployeeResponseDTO addEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO)
    {
        return employeeService.addEmployee(employeeRequestDTO);
    }

    @GetMapping("/*")
    public List<EmployeeResponseDTO> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/byId/{usn}")
    public EmployeeResponseDTO findById(@PathVariable int usn)
    {
        return employeeService.findById(usn);
    }

    @GetMapping("/byJobRole/{jobRole}")
    public List<EmployeeResponseDTO> findByJobRole(@PathVariable String jobRole)
    {
        return employeeService.findByJobRole(jobRole);
    }

    @PutMapping("/updateEmployee/{usn}")
    public EmployeeResponseDTO updateEmployee(@PathVariable int usn,@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO)
    {
        return employeeService.updateEmployee(usn,employeeRequestDTO);
    }

    @DeleteMapping("/deleteEmployee/{usn}")
    public String deleteEmployee(@PathVariable int usn)
    {
        return employeeService.deleteEmployee(usn);
    }
}

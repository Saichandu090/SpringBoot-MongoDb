package spring.mongo.seconddemo.Spring_Mongo.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import spring.mongo.seconddemo.Spring_Mongo.dto.EmployeeRequestDTO;
import spring.mongo.seconddemo.Spring_Mongo.dto.EmployeeResponseDTO;
import spring.mongo.seconddemo.Spring_Mongo.model.Employee;
import spring.mongo.seconddemo.Spring_Mongo.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO)
    {
        Employee employee=new Employee();
        employee.setUsn(new Random().nextInt(1000));
        employee.setName(employeeRequestDTO.getName());
        employee.setCity(employeeRequestDTO.getCity());
        employee.setJobRole(employeeRequestDTO.getJobRole());
        employee.setJobSal(employeeRequestDTO.getJobSal());
        employee.setJobLocation(employeeRequestDTO.getJobLocation());
        employee.setDeploymentDate(employeeRequestDTO.getDeploymentDate());
        employee.setEmail(employeeRequestDTO.getEmail());

        return employeeToResponseDTO(employeeRepository.save(employee));
    }

    public EmployeeResponseDTO employeeToResponseDTO(Employee employee)
    {
        EmployeeResponseDTO responseDTO=new EmployeeResponseDTO();
        responseDTO.setName(employee.getName());
        responseDTO.setCity(employee.getCity());
        responseDTO.setJobRole(employee.getJobRole());
        responseDTO.setJobLocation(employee.getJobLocation());
        return responseDTO;
    }

    public List<EmployeeResponseDTO> getAllEmployees()
    {
        List<Employee> employeeList=employeeRepository.findAll();
        List<EmployeeResponseDTO> responseDTOS=new ArrayList<>();
        for(Employee e : employeeList)
        {
            responseDTOS.add(employeeToResponseDTO(e));
        }
        return responseDTOS;
    }

    public EmployeeResponseDTO findById(int usn)
    {
        Employee employee=employeeRepository.findById(usn).orElseThrow(()->new RuntimeException("Employee Not Found"));
        return employeeToResponseDTO(employee);
    }

    public List<EmployeeResponseDTO> findByJobRole(String jobRole)
    {
        List<Employee> employeeList=employeeRepository.findByJobRole(jobRole);
        List<EmployeeResponseDTO> responseDTOS=new ArrayList<>();
        for(Employee e: employeeList)
        {
            responseDTOS.add(employeeToResponseDTO(e));
        }
        return responseDTOS;
    }

    public EmployeeResponseDTO updateEmployee(int usn,EmployeeRequestDTO employeeRequestDTO)
    {
        Employee employee=employeeRepository.findById(usn).orElseThrow(()->new RuntimeException("Employee Not Found!!"));
        employee.setName(employeeRequestDTO.getName());
        employee.setCity(employeeRequestDTO.getCity());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setJobRole(employeeRequestDTO.getJobRole());
        employee.setJobSal(employeeRequestDTO.getJobSal());
        employee.setJobLocation(employeeRequestDTO.getJobLocation());
        employee.setDeploymentDate(employeeRequestDTO.getDeploymentDate());
        return employeeToResponseDTO(employeeRepository.save(employee));
    }

    public String deleteEmployee(int usn)
    {
        EmployeeResponseDTO employeeResponseDTO=findById(usn);
        employeeRepository.deleteById(usn);
        return "Employee with Id "+usn+" deleted Successfully from DataBase!!";
    }
}

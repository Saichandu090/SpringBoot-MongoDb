package spring.mongo.seconddemo.Spring_Mongo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.mongo.seconddemo.Spring_Mongo.dto.StudentDTO;
import spring.mongo.seconddemo.Spring_Mongo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public StudentDTO addStudent(@Valid @RequestBody StudentDTO studentDTO)
    {
        return service.addStudent(studentDTO);
    }

    @GetMapping("/byId/{usn}")
    public StudentDTO findById(@PathVariable int usn)
    {
        return service.findById(usn);
    }

    @GetMapping("/byPhone/{phone}")
    public StudentDTO findByPhone(@PathVariable long phone)
    {
        return service.findByPhone(phone);
    }

    @GetMapping("/*")
    public List<StudentDTO> getAllStudent()
    {
        return service.getAllStudent();
    }

    @PutMapping("/updateStudent/{usn}")
    public StudentDTO updateStudent(@PathVariable int usn,@RequestBody StudentDTO studentDTO)
    {
        return service.updateStudent(usn,studentDTO);
    }

    @DeleteMapping("/deleteStudent/{usn}")
    public String deleteStudent(@PathVariable int usn)
    {
        return service.deleteStudent(usn);
    }

}

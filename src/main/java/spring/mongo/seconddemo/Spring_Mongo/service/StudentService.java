package spring.mongo.seconddemo.Spring_Mongo.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mongo.seconddemo.Spring_Mongo.dto.StudentDTO;
import spring.mongo.seconddemo.Spring_Mongo.model.Student;
import spring.mongo.seconddemo.Spring_Mongo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO addStudent(StudentDTO studentDTO)
    {
        Student std =new Student();
        std.setUsn(new Random().nextInt(1000));
        std.setName(studentDTO.getName());
        std.setAddress(studentDTO.getAddress());
        std.setEmail(studentDTO.getEmail());
        std.setPhone(studentDTO.getPhone());
        Student student=studentRepository.save(std);
        return studentToDTO(student);
    }

    private StudentDTO studentToDTO(Student student)
    {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPhone(student.getPhone());
        return studentDTO;
    }

    public List<StudentDTO> getAllStudent()
    {
        List<Student> studentList=studentRepository.findAll();
        List<StudentDTO> studentDTOS=new ArrayList<>();
        for(Student i : studentList)
        {
            studentDTOS.add(studentToDTO(i));
        }
        return studentDTOS;
    }

    public StudentDTO findById(int usn)
    {
        Student student = studentRepository.findById(usn).orElseThrow(()-> new RuntimeException("Student not found"));
        return studentToDTO(student);
    }

    public StudentDTO findByPhone(long phone)
    {
        Student student = studentRepository.findByPhone(phone);
        return studentToDTO(student);
    }

    public StudentDTO updateStudent(int usn,StudentDTO studentDTO)
    {
        Student student = studentRepository.findById(usn).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());
        return studentToDTO(studentRepository.save(student));
    }

    public String deleteStudent(int usn)
    {
        StudentDTO studentDTO=findById(usn);
        studentRepository.deleteById(usn);
        return "Student deleted";
    }
}

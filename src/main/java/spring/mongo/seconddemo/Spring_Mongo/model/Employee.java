package spring.mongo.seconddemo.Spring_Mongo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "employee_db")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee
{
    @Id
    private int usn;
    private String name;
    private String city;
    private String email;
    private LocalDate deploymentDate;
    private String jobRole;
    private String jobLocation;
    private int jobSal;
}

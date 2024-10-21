package spring.mongo.seconddemo.Spring_Mongo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO
{
    @Pattern(regexp = "^[A-Z][A-Za-z ]{2,}$")
    private String name;
    @NotBlank(message = "City name should not be blank")
    private String city;
    @Email
    private String email;

    private LocalDate deploymentDate;
    @NotBlank
    private String jobRole;
    @NotBlank
    private String jobLocation;

    private int jobSal;
}

package spring.mongo.seconddemo.Spring_Mongo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO
{
    @Pattern(regexp = "^[A-Z][A-Z a-z]{2,}$",message = "Name should start with capital letter")
    private String name;
    @NotNull
    private String address;
    @Email
    private String email;
    private long phone;
}

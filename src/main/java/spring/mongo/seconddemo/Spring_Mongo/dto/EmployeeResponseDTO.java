package spring.mongo.seconddemo.Spring_Mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO
{
    private String name;
    private String city;
    private String jobRole;
    private String jobLocation;
}

package spring.mongo.seconddemo.Spring_Mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student
{
    @Id
    private int usn;
    private String name;
    private String address;
    private String email;
    private long phone;
}

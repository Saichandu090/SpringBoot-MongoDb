package spring.mongo.seconddemo.Spring_Mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring.mongo.seconddemo.Spring_Mongo.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer>
{
    Student findByPhone(long phone);
}

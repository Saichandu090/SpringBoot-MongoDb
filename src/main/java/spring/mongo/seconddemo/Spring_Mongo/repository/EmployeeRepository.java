package spring.mongo.seconddemo.Spring_Mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import spring.mongo.seconddemo.Spring_Mongo.dto.EmployeeResponseDTO;
import spring.mongo.seconddemo.Spring_Mongo.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer>
{
    @Query("{jobRole: ?0 }")
    List<Employee> findByJobRole(String jobRole);
}

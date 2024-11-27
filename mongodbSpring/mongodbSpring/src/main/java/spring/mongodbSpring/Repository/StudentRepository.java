package spring.mongodbSpring.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.mongodbSpring.Entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
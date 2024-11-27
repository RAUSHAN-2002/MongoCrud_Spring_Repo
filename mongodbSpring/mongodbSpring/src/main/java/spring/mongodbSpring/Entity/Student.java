package spring.mongodbSpring.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "students")
@Getter
@Setter
public class Student{

    @Id
    private String id;
    private String name;
    private String email;
    private String mobile;




}


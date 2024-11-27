package spring.mongodbSpring.StudentDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Unwrapped;

@Getter
@Setter
public class StudentDto {


    private String id;

    @NotBlank(message="Name is must required")
    @Size(min = 3 , message="characters must be  3 characters")
    private String name;

    @NotBlank(message="email is required")
    @Email
    private String email;

    @NotBlank
    @Size(min = 10 ,max=11,message = "give atleat 10 digits no")
    private String mobile;
}

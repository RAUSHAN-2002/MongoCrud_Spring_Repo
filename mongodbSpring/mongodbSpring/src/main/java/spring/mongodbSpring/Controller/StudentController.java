package spring.mongodbSpring.Controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.mongodbSpring.Entity.Student;
import spring.mongodbSpring.Service.StudentService;
import spring.mongodbSpring.StudentDto.StudentDto;

import java.util.List;

@RestController
@RequestMapping("/student/v1/api")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<?> addstudent(@Valid @RequestBody
                                            StudentDto dto,
                                        BindingResult result
    ){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        StudentDto Studto = studentService.addStudent(dto);
        return new ResponseEntity<>(Studto,HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id){
        studentService.deletedStudent(id);
        return String.format("Student with ID %s deleted successfully.", id);

    }

    @PutMapping
    public ResponseEntity<StudentDto> UpdateStudent(
            @RequestParam String id,
            @RequestBody StudentDto dto
        ){
        StudentDto stude= studentService.updateStudent(id, dto);
        return new ResponseEntity<>(stude,HttpStatus.OK);
   }
    @GetMapping
    public ResponseEntity<List<Student>>  getAllStudent(
            @RequestParam(name="pageSize",required = false,defaultValue = "3") int pageSize,
            @RequestParam(name="pageNo",required = false,defaultValue ="0") int pageNo,
            @RequestParam(name="sortBy",required=false, defaultValue = "name") String sortBy,
            @RequestParam(name="sortDir",required=false, defaultValue="asc") String sortDir
    ){
        List<Student> allStudent = studentService.getAllStudent(pageNo,pageSize,sortBy,sortDir);
        return  new ResponseEntity<>(allStudent,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id){
        StudentDto sudto = studentService.findStudentById(id);
        return  new ResponseEntity<>(sudto,HttpStatus.OK);

    }


}

package spring.mongodbSpring.Service;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import spring.mongodbSpring.Entity.Student;
import org.modelmapper.ModelMapper;
import spring.mongodbSpring.Exception.DuplicateResourceException;
import spring.mongodbSpring.Exception.ResourceNotFoundException;
import spring.mongodbSpring.Repository.StudentRepository;
import spring.mongodbSpring.StudentDto.StudentDto;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository= studentRepository;
        this.modelMapper = modelMapper;
    }


    public StudentDto addStudent(StudentDto dto) {

            Student stu = maptoEntity(dto);
            Student student = studentRepository.save(stu);
            StudentDto studto = maptoDto(student);
            return  studto;


    }

    public List<Student> getAllStudent(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort asc = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy) : Sort.by(sortBy).descending();
    Pageable pageable = PageRequest.of(pageNo, pageSize, asc);
        Page<Student> all = studentRepository.findAll(pageable);
             return all.getContent();
    }

    public void deletedStudent(String id) {
        studentRepository.deleteById(id);
    }


    public StudentDto updateStudent(String id, StudentDto dto) {
        Student student = maptoEntity(dto);
        student.setId(id);
        Student updatedStudent = studentRepository.save(student);
        return maptoDto(updatedStudent);
    }


    public StudentDto findStudentById(String id) {
        Student byIdStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found give correct id"));
        StudentDto dto = maptoDto(byIdStudent);
        return dto;

    }

     StudentDto maptoDto(Student student){
         StudentDto dto = modelMapper.map(student, StudentDto.class);
         return dto;
     }


     Student maptoEntity(StudentDto dto){
         Student stu = modelMapper.map(dto, Student.class);
         return stu;
     }

}

package com.mapsa.mockitodemo.service;

import com.mapsa.mockitodemo.domain.Student;
import com.mapsa.mockitodemo.repo.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

//@SpringBootTest // [Component] Integration Test
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    //    @Autowired
//    @Spy
//    @InjectMocks
    StudentServiceImpl studentService;
    //    @MockBean
    @Mock
    StudentRepository studentRepository;


    //    @Mock
    //    private Student student;
    //    Student student = Mockito.mock(Student.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(studentRepository);
//        studentService = spy(StudentServiceImpl.class);
    }

    @Test
    void getAllStudents() {
        when(studentRepository.findAll())
                .thenReturn(List.of(new Student().setName("ali")
                                .setStudentId("123123"),
                        new Student().setName("reza").setStudentId("12312")));
        Assertions.assertEquals(studentService.getAllStudents()
                .size(), 2);
    }

    @Test
    void findStudentById() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(new Student().setId(1L)));
        Assertions.assertEquals(studentService.findStudentById(1L).getId(), 1L);
    }

    @Test
    void createStudent() {
        Student student = new Student().setId(13L).setName("Ali").setStudentId("123415");
        when(studentRepository.save(student)).thenReturn(student);
        Assertions.assertEquals(studentService.createStudent(student), student);
    }

    @Test
    void deleteById() {
        studentService.deleteById(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    void searchByName() {
        when(studentRepository.findStudentByNameContaining("al"))
                .thenReturn(List.of(new Student().setName("ali"),
                        new Student().setName("alireza")));

        studentService.searchByName("al")
                .forEach(z -> Assertions.assertTrue(z.getName().contains("ali")));

        verify(studentRepository, times(1))
                .findStudentByNameContaining("al");
    }
}

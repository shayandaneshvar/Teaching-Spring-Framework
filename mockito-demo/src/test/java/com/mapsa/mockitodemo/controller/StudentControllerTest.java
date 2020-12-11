package com.mapsa.mockitodemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapsa.mockitodemo.repo.StudentRepository;
import com.mapsa.mockitodemo.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
//    private RestTemplate restTemplate;

    private MockMvc mockMvc;
//    @MockBean
    private StudentRepository studentRepository;
    @Mock
    private StudentServiceImpl studentService;
    @InjectMocks
    private StudentController controller;


    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
//        restTemplate = new RestTemplate();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();

    }

    @Test
    void help() throws Exception {
        // Integration Test
        //HttpClient httpClient = HttpClient.newBuilder().build();
//        WebClient
//        ResponseEntity<String> stringResponseEntity =
//                restTemplate.exchange("http://localhost:8192/student/help",
//                        HttpMethod.GET,
//                        null, String.class);
//        Assertions
//                .assertThat(stringResponseEntity.getStatusCode())
//                .isEqualTo(HttpStatus.OK);
        mockMvc.perform(get("/student/help"))
                .andExpect(status().isOk())
                .andExpect(content().string("Student Controller"));
    }

    @Test
    void getAllStudents() throws Exception {
        String string;
        MvcResult result = mockMvc
                .perform(get("/student/all"))
                .andExpect(status()
                        .isOk()).andReturn();
        string = result.getResponse().getContentAsString();
//        List list = objectMapper.readValue(string, List.class);
//        System.out.println(list);

    }

    @Test
    void getStudentById() {
        //
    }

    @Test
    void searchStudentByName() {
        //
    }

    @Test
    void createStudent() {
        // TODO: 12/11/2020
    }

    @Test
    void deleteStudentById() {
        // TODO: 12/11/2020
    }
}

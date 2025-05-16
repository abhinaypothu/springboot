package com.pothu.springbootpractice.controller;

import com.pothu.springbootpractice.entity.Department;
import com.pothu.springbootpractice.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @MockitoBean
    DepartmentService departmentService;

    @Autowired
    MockMvc mockMvc;


    Department outputDepartment;

    @BeforeEach
    public void before(){
        outputDepartment = Department.builder()
                .departmentAddress("Kalam")
                .departmentCode("Freshers")
                .departmentName("Freshers")
                .departmentId(1L)
                .build();

    }

    @Test
    void addDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Kalam")
                .departmentCode("Freshers")
                .departmentName("Freshers")
                .build();
        Mockito.when(departmentService.addDepartment(inputDepartment)).thenReturn(outputDepartment);

        mockMvc.perform(MockMvcRequestBuilders.post("/department/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"departmentName\": \"Freshers\",\n" +
                                "  \"departmentAddress\": \"Kalam\",\n" +
                                "  \"departmentCode\": \"Freshers\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void getDepartmentByName() throws Exception {

        Mockito.when(departmentService.getDepartmentByName("Freshers")).thenReturn(outputDepartment);
        mockMvc.perform(MockMvcRequestBuilders.get("/department/name/Freshers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"departmentName\": \"Freshers\",\n" +
                        "  \"departmentAddress\": \"Kalam\",\n" +
                        "  \"departmentCode\": \"Freshers\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(outputDepartment.getDepartmentName()))
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "  \"departmentName\": \"Freshers\",\n" +
                        "  \"departmentAddress\": \"Kalam\",\n" +
                        "  \"departmentCode\": \"Freshers\"\n" +
                        "}"));
    }
}
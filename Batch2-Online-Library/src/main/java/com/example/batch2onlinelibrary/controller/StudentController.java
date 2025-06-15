package com.example.batch2onlinelibrary.controller;

import com.example.batch2onlinelibrary.dtos.CreateStudentRequest;
import com.example.batch2onlinelibrary.dtos.GetStudentDetails;
import com.example.batch2onlinelibrary.dtos.UpdateStudentRequest;
import com.example.batch2onlinelibrary.models.Student;
import com.example.batch2onlinelibrary.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public Long createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return this.studentService.createStudent(createStudentRequest.toStudent());
    }

    @GetMapping("/get")
    public GetStudentDetails getStudentDetails(@RequestParam("id") Long studentId){
        return this.studentService.getStudentDetails(studentId);
    }

    @PatchMapping("/update/{studentId}")
    public GetStudentDetails updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest,
                                           @PathVariable("studentId") Long studentId){
        return this.studentService.updateStudent(updateStudentRequest.toStudent(),studentId);
    }

    @DeleteMapping("/delete")
    public GetStudentDetails deleteStudent(@RequestParam("studentId") Long studentId){
        return this.studentService.deactivate(studentId);
    }
}

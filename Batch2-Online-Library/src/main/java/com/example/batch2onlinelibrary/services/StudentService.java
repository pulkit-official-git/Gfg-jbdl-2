package com.example.batch2onlinelibrary.services;

import com.example.batch2onlinelibrary.dtos.GetStudentDetails;
import com.example.batch2onlinelibrary.dtos.UpdateStudentRequest;
import com.example.batch2onlinelibrary.models.Student;
import com.example.batch2onlinelibrary.models.StudentStatus;
import com.example.batch2onlinelibrary.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public Long createStudent(Student student) {
        student = this.studentRepository.save(student);
        return student.getId();
    }

    public GetStudentDetails getStudentDetails(Long studentId) {
        Student student = this.studentRepository.findById(studentId).orElse(null);

        return GetStudentDetails.builder()
                .student(student)
                .build();
    }

    public GetStudentDetails updateStudent(Student student, Long studentId) {

        Student existingStudent = this.studentRepository.findById(studentId).orElse(null);
//        student.setId(existingStudent.getId());
        Student target = this.merge(student, existingStudent);

        target=this.studentRepository.save(target);
        return GetStudentDetails.builder()
                .student(target)
                .build();

    }

    private Student merge(Student incoming, Student existing) {
        JSONObject incomingStudent = objectMapper.convertValue(incoming, JSONObject.class);
        JSONObject savedStudent = objectMapper.convertValue(existing, JSONObject.class);

        Iterator it = incomingStudent.keySet().iterator();  // id, name, email, mobile .....
        while (it.hasNext()) {
            String key = (String)it.next();
            if(incomingStudent.get(key) != null) {
                savedStudent.put(key, incomingStudent.get(key));
            }
        }

        return objectMapper.convertValue(savedStudent, Student.class);
    }


    public GetStudentDetails deactivate(Long studentId) {
        Student student = this.studentRepository.findById(studentId).orElse(null);
        if(student != null) {
           this.studentRepository.deactivate(studentId, StudentStatus.INACTIVE);
        }
        student = this.studentRepository.findById(studentId).orElse(null);
        return GetStudentDetails.builder()
                .student(student)
                .build();
    }
}

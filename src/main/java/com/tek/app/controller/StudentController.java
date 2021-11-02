package com.tek.app.controller;

import com.tek.app.model.Student;
import com.tek.app.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/insert")
    public Student insertStudent(@RequestBody Student student) {
        return service.insertStudent(student);
    }

    @PostMapping("/insertStudentList")
    public List<Student> insertListOfStudent(@RequestBody List<Student> studentList) {
        return service.insertListOfStudent(studentList);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/getStudentById")
    public Student getStudentByRollId(@RequestParam Integer rollId) {
        Student student=null;
        if(service.getStudentByRollId(rollId).isPresent()) {
            student=service.getStudentByRollId(rollId).get();
        }
        return student;
    }

    @PutMapping("/updateStudentById")
    public Student updateStudentById(@RequestParam Integer rollId, @RequestBody Student student) {
        return service.updateStudentById(rollId, student);
    }

    @DeleteMapping("/deleteByRollId")
    public void deleteStudentById(@RequestParam Integer rollId) {
        service.deleteStudentById(rollId);
        logger.info("Student Deleted " + rollId);
    }

}


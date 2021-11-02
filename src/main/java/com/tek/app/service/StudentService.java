package com.tek.app.service;

import com.tek.app.model.Student;
import com.tek.app.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student insertStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> insertListOfStudent(List<Student> studentList) {
        return repository.saveAll(studentList);
    }

    public Optional<Student> getStudentByRollId(Integer rollId) {
        return repository.findById(rollId);
    }

    public Student updateStudentById(Integer rollId, Student stud) {
        Student student = null;
        try {
            student = repository.getById(rollId);
        } catch (Exception e) {
            logger.info("Student not exist with this id " + rollId);
            e.printStackTrace();
        }
        student.setFirstName(stud.getFirstName());
        student.setLastName(stud.getLastName());
        student.setAddress(stud.getAddress());
        return repository.save(student);
    }

    public void deleteStudentById(Integer rollId) {
        repository.deleteById(rollId);
    }


}


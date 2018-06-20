package com.andreas.microservice.Controller;

import com.andreas.microservice.Entity.Student;
import com.andreas.microservice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){

        return studentService.getAllStudents();
    }

    @RequestMapping("/who")
    public String whoami(){return "Instanz 2";}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentByID(@PathVariable("id") int id){
        return studentService.getStundentByID(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentByID(@PathVariable("id") int id){
        studentService.deleteUserByID(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
}

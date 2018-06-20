package com.andreas.microservice.Dao;

import com.andreas.microservice.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    private static Map<Integer,Student> students;

    static {
        students = new HashMap<Integer, Student>() {

            {
                put(1,new Student(1,"Andreas","Infoprojekt"));
                put(2,new Student(2,"Ulf","Mathematik"));
                put(3,new Student(3,"Anke","Geschichte"));
            }
        };
    }

    public Collection<Student> getAllStudents(){

        return this.students.values();
    }

    public Student getStundentByID(int id){
        return students.get(id);
    }

    public void deleteUserByID(int id) {
        students.remove(id);
    }

    /*public void updateStudentByID(int id, Student student){
        students.replace(id, student);
    }*/
    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(),student);
    }

    public void insertStudent(Student student){
        students.put(student.getId(),student);
    }
}

package com.andreas.microservice.Service;

import com.andreas.microservice.Dao.StudentDao;
import com.andreas.microservice.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

       public Collection<Student> getAllStudents(){

           return this.studentDao.getAllStudents();
        }

        public Student getStundentByID(int id){

           return this.studentDao.getStundentByID(id);
        }

        public void deleteUserByID(int id) {
               this.studentDao.deleteUserByID(id);
        }

        public void updateStudent(Student student){
            this.studentDao.updateStudent(student);
        }

        public void insertStudent(Student student){
            this.studentDao.insertStudent(student);
        }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class StudentatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student emp1 = new Student(1, "John", 3.5);
       Student emp2 = new Student(2, "Marry", 4.00);
       StudentTable.insertStudent(emp1);
       StudentTable.insertStudent(emp2);
       //Student emp;
       //emp = StudentTable.findStudentById(1);
       //if (emp != null) {
       //    emp.setName("Jack");
           //StudentTable.removeStudent(emp);
       //    StudentTable.updateStudent(emp);
       //}
       //List<Student> empList = StudentTable.findStudentByName("Marry"); 
       List<Student> empList = StudentTable.findAllStudent();
       printAllStudent(empList);
    }
    public static void printAllStudent(List<Student> studentList) {
        for(Student std : studentList) {
           System.out.print(std.getId() + " ");
           System.out.print(std.getName() + " ");
           System.out.println(std.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

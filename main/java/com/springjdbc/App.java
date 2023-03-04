package com.springjdbc;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.springjdbc.dao.StudentDao;
import com.springjdbc.entites.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "my program started......." );
        //spring Jdbc=> JdbcTemplate
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
       StudentDao studentDao =  context.getBean("studentDao",StudentDao.class);
       
       // insert
		/*
		 * Student student = new Student(); 
		 * student.setId(666); 
		 * student.setName("Jhon");
		 * student.setCity("Lucknow");
		 *  int result = studentDao.insert(student);
		 * System.out.println(result);
		 */
       
       // update
		/*
		 * Student student = new Student(); student.setId(333);
		 * student.setName("pankaj"); student.setCity("Allahabad"); int result =
		 * studentDao.chnage(student); System.out.println(result);
		 */
       
       //delete
		/*
		 * int result = studentDao.delete(666);
		 *  System.out.println("deleted: "+result);
		 */
       
       //select
//       Student student = studentDao.getStudent(222);
//       System.out.println(student);
       
       List<Student> students = studentDao.getAllStudents();
       for(Student s: students) 
       {
    	   System.out.println(s);
       }   
    }
}

//JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);      
//// insert query
//String query = "insert into student(id,name,city) values(?,?,?)";      
//// fire query
//int result = template.update(query,333,"Chandan verma","Lucknow");
//System.out.println("number of record inserted.."+result);
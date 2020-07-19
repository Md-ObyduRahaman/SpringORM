package com.spring.orm.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		/*
		 * Student student = new Student(1194, "SOjib", "Mymensingh"); int insert =
		 * studentDao.insert(student); System.out.println("done....." + insert);
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("PRESS 1 for add new student");
			System.out.println("PRESS 2 for display  all students");
			System.out.println("PRESS 3 for get detail of single student");
			System.out.println("PRESS 4 for delete students");
			System.out.println("PRESS 5 for update student");
			System.out.println("PRESS 6 for exit");

			try {

				int input = Integer.parseInt(br.readLine());
//				if(input==1)
//				{
//					//add a new student
//				}else if(input==2)
//				{
//					//display
//				}

				switch (input) {

				case 1:
					// add a new student
					// taking inputs from users
					System.out.println("Enter user id : ");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("Enter user name :");
					String uName = br.readLine();

					System.out.println("Enter user city: ");
					String uCity = br.readLine();

					// creating student object and setting values
					Student s = new Student();
					s.setId(uId);
					s.setName(uName);
					s.setCity(uCity);

					// saving student object to database by calling insert of student dao
					int r = studentDao.insert(s);
					System.out.println(r + " student added");
					System.out.println("***************************************");
					System.out.println();

					break;
				case 2:
					// display all student
					System.out.println("**************************************");
					List<Student> allStudents = studentDao.getStudents();
					for (Student st : allStudents) {
						System.out.println("Id : " + st.getId());
						System.out.println("Name : " + st.getName());
						System.out.println("City : " + st.getCity());
						System.out.println("___________________________________");
					}

					System.out.println("**************************************");
					break;

				case 3:
					// get single student data
					System.out.println("Enter user id : ");
					int userId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId);
					System.out.println("Id : " + student.getId());
					System.out.println("Name : " + student.getName());
					System.out.println("City : " + student.getCity());
					System.out.println("___________________________________");

					break;
				case 4:
					// delete student;

					System.out.println("Enter user id : ");
					int id = Integer.parseInt(br.readLine());
					studentDao.delete(id);
					System.out.println("Student deleted...");
					break;

				case 5:
					// update the student
					break;

				case 6:
					// exit
					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input Try with another one !!");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thankyou for using my application");
		System.out.println("See you soon !!");

	}
}

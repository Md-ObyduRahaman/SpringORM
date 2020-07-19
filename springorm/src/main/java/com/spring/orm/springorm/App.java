package com.spring.orm.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;

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
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("PRESS 1 for add new student");
			System.out.println("PRESS 2 for display all student");
			System.out.println("PRESS 3 for get detail of single student");
			System.out.println("PRESS 4 for delete students");
			System.out.println("PRESS 5 for update  student");
			System.out.println("PRESS 6 for exit");
			try {

				int input = Integer.parseInt(bufferedReader.readLine());
				switch (input) {
				case 1:
					// add a new student

					break;
				case 2:
					// display all student

					break;
				case 3:
					// get a single student

					break;
				case 4:
					// delete student

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
				System.out.println("Invalid Input try with another one !!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thankyou using my applicanioin");
		System.out.println("see you soon!!");
	}
}

package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonDAO;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO dao) {
		return runner -> {
			System.out.println("======= Ready na ==========");
			// createData(dao);
			// deleteData(dao);
			// getData(dao);
			getAllData(dao);
			// updateData(dao);
		};
	}

	public void createData(PersonDAO dao) {
		Person person = new Person("Pawan", "Elec");
		dao.save(person);
		System.out.println("Person created: " + person);
	}

	public void deleteData(PersonDAO dao) {
		int id = 2;
		dao.delete(id);
		System.out.println("Person Deleted: " + 1);
		// for (int i = 27; i <= 30; i++) {
		// dao.delete(i);
		// System.out.println("Person Deleted: " + i);
		// }
	}

	public void getData(PersonDAO dao) {
		int id = 1;
		Person person = dao.get(id);
		System.out.println("Person: " + person); // แสดงผลแบบนี้นะ Person: Person{id=1, fname='John', lname='Doe'}
													// ซึ่งรูปแบบมันมาจาก toString() ที่เราสร้างไว้นั่นแหละ
	}

	public void getAllData(PersonDAO dao) {
		// dao.getAll().forEach(System.out::println);
		List<Person> persons = dao.getAll();
		System.out.println("Persons: ");
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	public void updateData(PersonDAO dao) {
		int id = 30;
		Person person = dao.get(id);
		person.setFname("คิวเอง");
		person.setLname("อีเล็ก");
		dao.update(person);
		System.out.println("Person Updated: " + person);
	}
}

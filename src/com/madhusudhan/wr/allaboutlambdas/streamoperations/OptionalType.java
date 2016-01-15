package com.madhusudhan.wr.allaboutlambdas.streamoperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.madhusudhan.wr.allaboutlambdas.domain.Student;
import com.madhusudhan.wr.allaboutlambdas.domain.Teacher;

/**
 * This class demonstrates the usage of the Optional type
 * 
 * @author mkonda
 *
 */
public class OptionalType {

	/**
	 * Find the sum of attendees but access the optional appropriately
	 */
	private void sumOfAttendees() {
		// List of attendees to various talks
		List<Integer> attendees = Arrays.asList(22, 10, 13, 9);

		// Total attendees at the conference
		Optional<Integer> totalAttendees = attendees.stream().reduce(
				Integer::sum);

		// Use the isPresent on the optional before accessing the value
		int total = totalAttendees.isPresent() ? totalAttendees.get() : 0;

		System.out.println("Total attendees: " + total);
	}

	private void noAttendeesOptional() {
		List<Integer> attendees = Arrays.asList();
		Optional<Integer> noAttendees = attendees.stream().reduce(Integer::sum);

		if (noAttendees.isPresent())
			System.out.println(noAttendees.get());

	}

	private void creatingOptionals() {
		Student student = new Student();
		Optional<Student> studentOptional = Optional.of(student);
		studentOptional.ifPresent(System.out::println);

		student = null;
		Optional<Student> studentOptional2 = Optional.ofNullable(student);

		System.out.println("Student can't be null:" + studentOptional2);

	}

	private void usingIfPresent() {
		Student student = new Student();
		Optional<Student> studentOptional = Optional.of(student);
		studentOptional.ifPresent(System.out::println);
	}

	/**
	 * Using orElse function
	 */
	private void usingOrElse() {
		Student student = null;
		Student defaultStudent = new Student();
		defaultStudent.setName("Default John");
		
		// We know that following optional is an issue
		Optional<Student> studentOptional = Optional.ofNullable(student);
		
		// Accessing the above will throw a NoSuchElementException
		// System.out.println(studentOptional.get());
		
		// To avoid such issues, use the orElse that acts as a safe guard
		String name = studentOptional.orElse(defaultStudent).getName();
		System.out.println("Get Name: " + name);

	}
	/**
	 * Use orElseThrow to throw an exception if we are expecting an exception
	 * @throws Exception
	 */

	private void usingOrElseThrow() throws Exception {
		Optional<Student> studentOptional = null;
		studentOptional.orElseThrow(Exception::new);
	}

	private void filteringAndMapping() {
		Student s = new Student();
		s.setName("John Lingham");
		s.setTeacher(new Teacher("Prof. Pandit"));

		Optional<Student> studentOptional = Optional.of(s);
		studentOptional
		  .filter(student -> student.hasTeacher())
		  .ifPresent(System.out::println);
		
		studentOptional
		  .map(student -> student.getName())
		  .ifPresent(System.out::println);
	}

	public static void main(String[] args) {
		/**
		 * Uncomment these invocations as required
		 */
//		new OptionalType().sumOfAttendees();
//		new OptionalType().noAttendeesOptional();
//		new OptionalType().creatingOptionals();
//		new OptionalType().usingIfPresent();
//		new OptionalType().usingOrElse();
		
//		try {
//			new OptionalType().usingOrElseThrow();
//		} catch (Exception e) {
//			System.out.println("Expected exception: ");
//			e.printStackTrace();
//		}
//		
//		 new OptionalType().filteringAndMapping();
	}

}

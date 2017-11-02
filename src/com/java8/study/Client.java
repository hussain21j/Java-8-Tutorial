package com.java8.study;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Client {
	public static void main(String[] args) {
		List<Person> listPerson = Arrays.asList(new Person("Berry", "Van", 38),
				new Person("Satish", "Chandra", 36),
				new Person("Marek", "Kapo", 33),
				new Person("Norbert", "Ten", 31),
				new Person("Peter", "Derens", 42));
		
		//sort by last name
		Collections.sort(listPerson, (Person o1, Person o2) ->  {
			return o1.getLastName().compareTo(o2.getLastName());
		});
		System.out.println("*************Printing sorted list******************");
		printList(listPerson);
		
		System.out.println("\n*************Printing sorted list******************");
		/*printConditionally(listPerson, new Conditition() {
			@Override
			public boolean test(Person person) {
				return person.getFirstName().startsWith("S");
			}
		});*/
		
		
		
		System.out.println("\n\n\n*******************Java 8**********************");
		System.out.println("\n*************Printing sorted list******************");
		printConditionally(listPerson, (person) -> {
			if(person.getFirstName().startsWith("S")){
				return true;
			}
			else {
				return false;
			}
		});
	}
	
	public static void printList(List<Person> listPerson){
		for(Person person : listPerson){
			System.out.println(person);
		}
	}
	
	
	
	public static void printConditionally(List<Person> listPerson, Predicate<Person> conditition){
		for(Person person : listPerson){
			if(conditition.test(person)){
				System.out.println(person);
			}
		}
		
	}
}



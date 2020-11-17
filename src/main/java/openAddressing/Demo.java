package openAddressing;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		int id, choice;
		String name;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter initial size of table : ");
		int size = scanner.nextInt();

		HashTable table = new HashTable(size);

		while (true) {
			System.out.println("1. Insert a record");
			System.out.println("1. Search a record");
			System.out.println("3. Delete a record");
			System.out.println("4. Display table");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			if (choice == 5) {
				break;
			}

			switch (choice) {
			case 1:
				System.out.print("Enter student id : ");
				id = scanner.nextInt();
				System.out.print("Enter student name : ");
				name = scanner.next();
				StudentRecord record = new StudentRecord(id, name);
				table.insert(record);
				break;
			case 2:
				System.out.print("Enter a record to be searched : ");
				id = scanner.nextInt();
				StudentRecord searchedStudentRecord = table.search(id);
				if (searchedStudentRecord == null) {
					System.out.println("Key not found");
				} else {
					System.out.println(searchedStudentRecord);
				}
				break;
			case 3:
				System.out.print("Enter a key to be deleted : ");
				id = scanner.nextInt();
				table.delete(id);
				break;
			case 4:
				table.displayTable();
				break;
			}
		}
		scanner.close();
	}

}

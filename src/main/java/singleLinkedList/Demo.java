package singleLinkedList;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		int choice, data, k, x;
		
		Scanner scan = new Scanner(System.in);
		
		SingleLinkedList List = new SingleLinkedList();
		
		List.createList();
		while(true) {
			System.out.println();
			System.out.println("1. Display List");
			System.out.println("2. Count The No of Nodes In List");
			System.out.println("3. Search For An Element In List");
			System.out.println("4. Insert In Empty List/ Insert In Begning Of The List");
			System.out.println("5. Insert A Node At The End Of The List");
			System.out.println("6. Insert A Node After A Specific Node");
			System.out.println("7. Insert A Node Before A Specific Node");
			System.out.println("8. Insert A Node At A Given Position");
			System.out.println("9. Delete First Node");
			System.out.println("10. Delete Last Node");
			System.out.println("11. Delete Any Node");
			System.out.println("12. Reverse The List");
			System.out.println("13. Bubble Sort By Exchanging Data");
			System.out.println("14. Bubble Sort By Exchanging Links");
			System.out.println("15. Merge Sort");
			System.out.println("16. Insert Cycle");
			System.out.println("17. Detect Cycle");
			System.out.println("18. Remove List");
			System.out.println("19. Quit");
			
			System.out.print("Enter your choice : ");
			choice = scan.nextInt();
			
			if(choice==19) {
				break;
			}
			
			switch(choice) {
			case 1: 
				List.displayList();
				break;
			case 2: 
				List.countNodes();
				break;
			case 3: 
				System.out.print("Enter the element to be serached : ");
				data = scan.nextInt();
				List.search(data);
				break;
			case 4: 
				System.out.print("Enter the element to be inserted in beginning : ");
				data = scan.nextInt();
				List.insertInBeginning(data);
				break;
			case 5: 
				System.out.print("Enter the element to be inserted at the end : ");
				data = scan.nextInt();
				List.insertAtEnd(data);
				break;
			case 6: 
				System.out.print("Enter the element to be inserted : ");
				data = scan.nextInt();
				List.insertInBeginning(data);
				break;
			
			}
		}

	}

}

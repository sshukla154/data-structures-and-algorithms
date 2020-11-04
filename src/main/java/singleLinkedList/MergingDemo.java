package singleLinkedList;

public class MergingDemo {

	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		SingleLinkedList list2 = new SingleLinkedList();

		list1.createList();
		list2.createList();

		list1.BubbleSortExchangingData();
		list2.BubbleSortExchangingLink();

		System.out.println("First List : ");
		list1.displayList();
		System.out.println("Second List : ");
		list2.displayList();

		SingleLinkedList list3;
		list3 = list1.mergeByCreatingNewList(list2);

		System.out.print("Third List (Merged List) By New List : ");
		list3.displayList();
		System.out.print("First List : ");
		list1.displayList();
		System.out.print("Second List : ");
		list2.displayList();

		list3 = list1.mergeByRearrangingList(list2);

		System.out.print("Third List (Merged List) By Link : ");
		list3.displayList();
		System.out.print("First List : ");
		list1.displayList();
		System.out.print("Second List : ");
		list2.displayList();

	}

}

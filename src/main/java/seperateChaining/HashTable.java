package seperateChaining;

public class HashTable {

	private SingleLinkedList[] singleLinkedListArray;

	// Size of array
	private int sizeOfArray;

	// No of records
	private int n;

	public HashTable() {
		this(11);
	}

	public HashTable(int tableSize) {
		sizeOfArray = tableSize;
		singleLinkedListArray = new SingleLinkedList[sizeOfArray];
	}

	public int hash(int key) {
		return (key % sizeOfArray);
	}

	public void displayTable() {
		System.out.println("Number of records = " + n);
		for (int i = 0; i < sizeOfArray; i++) {
			System.out.print("[" + i + "] ---> ");
			if (singleLinkedListArray[i] != null) {
				singleLinkedListArray[i].displayList();
			} else {
				System.out.println("____");
			}
		}
	}

	public StudentRecord search(int key) {
		int h = hash(key);

		if (singleLinkedListArray[h] != null) {
			return singleLinkedListArray[h].search(key);
		}

		return null;
	}

	public void insert(StudentRecord newStudentRecord) {
		int key = newStudentRecord.getStudentId();
		int h = hash(key);
		
		if(singleLinkedListArray[h] == null) {
			singleLinkedListArray[h] = new SingleLinkedList();
		}
		singleLinkedListArray[h].insertInBeginning(newStudentRecord);
		n++;
	}

	public void delete(int key) {
		int h = hash(key);
		if (singleLinkedListArray[h] != null) {
			singleLinkedListArray[h].deleteNode(key);
			n--;
		} else {
			System.out.println(key + " is not present.");
		}
	}

}

package openAddressing;

public class HashTable {

	private StudentRecord[] studentRecordArray;

	// Size of array
	private int sizeOfArray;

	// No of records
	private int n;

	public HashTable() {
		this(11);
	}

	public HashTable(int tableSize) {
		sizeOfArray = tableSize;
		studentRecordArray = new StudentRecord[sizeOfArray];
		n = 0;
	}

	public int hash(int key) {
		return (key % sizeOfArray);
	}

	public void insert(StudentRecord newStudentRecord) {
		int key = newStudentRecord.getStudentId();
		int h = hash(key);
		int location = h;

		for (int i = 1; i < sizeOfArray; i++) {
			if (studentRecordArray[location] == null || studentRecordArray[location].getStudentId() == -1) {
				studentRecordArray[location] = newStudentRecord;
				n++;
				return;
			}
			if (studentRecordArray[location].getStudentId() == key) {
				throw new UnsupportedOperationException("Duplicate Key");
			}
			// Linear probing technique
			location = (h + i) % sizeOfArray;
		}
		System.out.println("Table is full : Record can't be inserted");
	}

	public StudentRecord search(int key) {
		int h = hash(key);
		int location = h;

		for (int i = 1; i < sizeOfArray; i++) {
			if (studentRecordArray[location] == null) {
				return null;
			}
			if (studentRecordArray[location].getStudentId() == key) {
				return studentRecordArray[location];
			}
			// Linear probing technique
			location = (h + i) % sizeOfArray;
		}
		return null;
	}

	public void displayTable() {
		for (int i = 0; i < sizeOfArray; i++) {
			System.out.print("[" + i + "] ---> ");
			if (studentRecordArray[i] != null && studentRecordArray[i].getStudentId() != -1) {
				System.out.println(studentRecordArray[i]);
			} else {
				System.out.println("____");
			}
		}
	}

	public StudentRecord delete(int key) {
		int h = hash(key);
		int location = h;

		for (int i = 1; i < sizeOfArray; i++) {
			if (studentRecordArray[location] == null) {
				return null;
			}
			if (studentRecordArray[location].getStudentId() == key) {
				StudentRecord temp = studentRecordArray[location];
				studentRecordArray[location].setStudentId(-1);
				return temp;
			}
			// Linear probing technique
			location = (h + i) % sizeOfArray;
		}
		return null;
	}

}

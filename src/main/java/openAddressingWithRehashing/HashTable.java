package openAddressingWithRehashing;

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

	public void insert1(StudentRecord newStudentRecord) {

		if (n >= sizeOfArray / 2) {
			rehash(nextPrime(2 * sizeOfArray));
			System.out.println("New Table size is : " + sizeOfArray);
		}
		insert(newStudentRecord);

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

	private void rehash(int newSize) {
		HashTable temp = new HashTable(newSize);

		for (int i = 0; i < sizeOfArray; i++) {
			if (studentRecordArray[i] != null && studentRecordArray[i].getStudentId() != -1) {
				temp.insert(studentRecordArray[i]);
			}
		}

		studentRecordArray = temp.studentRecordArray;
		sizeOfArray = newSize;

	}

	private int nextPrime(int x) {
		while (!isPrime(x)) {
			x++;
		}
		return x;
	}

	private boolean isPrime(int x) {

		for (int i = 2; i < x; i++) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}

	public void delete(int key) {
		int h = hash(key);
		int location = h;

		for (int i = 1; i < sizeOfArray; i++) {
			if (studentRecordArray[location] == null) {
				return;
			}
			if (studentRecordArray[location].getStudentId() == key) {
				studentRecordArray[location].setStudentId(-1);
				n--;
				if (n > 0 && n <= sizeOfArray / 8) {
					rehash(nextPrime(sizeOfArray / 2));
					System.out.println("New table size is : " + sizeOfArray);
				}
			}
			// Linear probing technique
			location = (h + i) % sizeOfArray;
		}
	}

	public int hash(int key) {
		return (key % sizeOfArray);
	}

}

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}
	public static void Array_addRemoveTest(){
		System.out.println("Running add/remove test.");
		ArrayDeque<Integer> ad=new ArrayDeque<>();
		boolean passed=checkEmpty(true,ad.isEmpty());
		ad.addFirst(1);
		ad.addLast(2);
		passed=checkSize(2,ad.size()) &&passed;
		int t=ad.removeFirst();
		System.out.println("remove first"+Integer.toString(t));
		passed=checkSize(1,ad.size())&&passed;
		t=ad.removeFirst();
		System.out.println("remove first"+Integer.toString(t));
		passed=checkEmpty(true,ad.isEmpty())&&passed;

		ad.addLast(3);
		ad.addLast(4);
		ad.addLast(5);
		t=ad.removeFirst();
		System.out.println("remove first"+Integer.toString(t));
		t=ad.removeFirst();
		System.out.println("remove first"+Integer.toString(t));
		passed=checkSize(1,ad.size()) &&passed;
		t=ad.removeLast();
		System.out.println("remove Last"+Integer.toString(t));
		passed=checkEmpty(true,ad.isEmpty())&&passed;

		printTestStatus(passed);
	}

	public static void Array_AddisEmptySizeTest(){
		System.out.println("Rrunnig add/isEmpty/Size test!");

		ArrayDeque<String> ad= new ArrayDeque<>();

		boolean passed= checkEmpty(true,ad.isEmpty());
		ad.addFirst("front");

		passed=checkSize(1,ad.size()) && passed;
		passed=checkEmpty(false,ad.isEmpty());

		ad.addLast("middle");
		passed=checkSize(2,ad.size()) && passed;

		ad.addLast("back");
		ad.addLast("back2");
		ad.addLast("back3");
		ad.addLast("back4");
		ad.addLast("back5");
		passed=checkSize(7,ad.size()) && passed;

		ad.addFirst("first1");
		ad.addFirst("first2");
		passed=checkSize(9,ad.size());

		String t;
        t=ad.removeFirst();
        System.out.println("remove first"+t);
        t=ad.removeFirst();
        System.out.println("remove first"+t);
        t=ad.removeLast();
        System.out.println("remove Last"+t);

        t=ad.removeLast();
        System.out.println("remove Last"+t);

        t=ad.removeLast();
        System.out.println("remove Last"+t);

        t=ad.removeLast();
        System.out.println("remove Last"+t);

		System.out.println("Printinng out deque");
		ad.printDeque();

		printTestStatus(passed);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
//		addIsEmptySizeTest();
//		addRemoveTest();
		Array_AddisEmptySizeTest();
//		Array_addRemoveTest();
	}
} 
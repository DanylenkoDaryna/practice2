package ua.nure.danylenko.practice2;

public class QueueTests {
	
	public static void main(String[] args) {
		test1();
		System.out.println();
	}
	
	private static void test1() {

		Class c = QueueImpl.class;

		// must be 1
		System.out.println(c.getInterfaces().length);

		// must be Queue
		System.out.println(c.getInterfaces()[0].getSimpleName());

		// must be 1
		System.out.println(c.getInterfaces()[0].getInterfaces().length);

		// must be Container
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getSimpleName());

		// must be 1
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getInterfaces().length);

		// must be java.lang.Iterable
		System.out.println(c.getInterfaces()[0].getInterfaces()[0].getInterfaces()[0].getName());

		/* an output must be as the following:
		*************************************
		1
		Queue
		1
		Container
		1
		java.lang.Iterable
		*************************************
		*/
	}
}

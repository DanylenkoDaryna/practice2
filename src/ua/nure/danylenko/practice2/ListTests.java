package ua.nure.danylenko.practice2;

public class ListTests {
    private static final String BORDER = "*************************************";

    public static void main(String[] args) {
        System.out.println("Test 1");
        System.out.println(BORDER);
        test1();

    }

    private static void test1() {

        Class c = ListImpl.class;

        // must be 1
        System.out.println(c.getInterfaces().length);

        // must be List
        System.out.println(c.getInterfaces()[0].getSimpleName());

        // must be java.lang.Object
        System.out.println(c.getSuperclass().getName());

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
		List
		java.lang.Object
		1
		Container
		1
		java.lang.Iterable
		*************************************
		*/
    }


}
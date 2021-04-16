package ua.nure.danylenko.practice2;


public class StackTests {
    private static final String BORDERN = "\n----\n";

    public static void main(String[] args) {
        test1();
        System.out.println(BORDERN);

    }

    private static void test1() {

        Class c = StackImpl.class;

        // must be 1
        System.out.println(c.getInterfaces().length);

        // must be Stack
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
		Stack
		1
		Container
		1
		java.lang.Iterable
		*************************************
		*/
    }

}

// Most basic block
// Everyone has access to this
public class AppHelloWorld {
	public static void main(String args[]) {
		System.out.println("HelloWorld");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

	private static int sum(int numbers[]) {
		int output = 0;
		for (int i = 0; i < numbers.length; i++) {
			output += numbers[i];
		}
		return output;
	}
}
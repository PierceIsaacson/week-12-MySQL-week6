import java.util.Random;

public class TestDemo {
	
	/*
	 * Method to add only positive integers together and return, or throw an
	 * exception to the user if at least one entry is zero or less than.
	 */
	public int addPositive(int a, int b) {
		if (a<=0 || b<=0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a+b;
	}
	/*
	 * Method to square a random number from a number generator then return.
	 */
	 public int randomNumberSquared() { 
		 int a = getRandomInt();
		 return (a*a);
	 }
	/*
	 * Random number generator method.
	 */
	 int getRandomInt() {
		  Random random = new Random();
		  return random.nextInt(10) + 1;
	}
	
}

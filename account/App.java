package account;

public class App {

	public static void main(String[] args) {
		Account acc1 = new Account("111",10000.0, 3.8);
		System.out.println(acc1);
		
		acc1.deposit(15000);
		System.out.println(acc1);
		
		String result = acc1.withdraw(50000);
		System.out.println(result);
		System.out.println(acc1);
		
		
	}

}

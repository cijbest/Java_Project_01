package forwhile;
/*****************************************************
 * Number Guess Game
 * 1. ���α׷��� �����Ѵ�.
 * 2. 1~100 ���̿� ���� ������ �ڵ� �����ȴ�.
 * 3. ����ڴ� 1~100������ ���ڸ� �Է��Ѵ�.
 * 4. �Է��� ���� ������ ����ų� ���ڰ� �ԷµǸ� �ٽ� �Է� �϶�� ���´�.
 * 5. �Է��� ���ڰ� ������ ������ ũ�� ũ��
 *    ������ �۴ٶ�� ǥ���Ѵ�.
 * 6. ������ �����̶�� ǥ���Ѵ�.
 * 7. ���� �� Ƚ���� ǥ���Ѵ�.
 * 8. ������ ���߸� �ٽ� ������ ���� ������ �ٽ� ���� �Ѵ�.
 * 9. ������ ���� Ƚ���� ǥ�� �Ѵ�.
 * 
 * String str = "A"; char c = 'A'; char c2 = str.charAt(0); // c1 == c2 �񱳰� ����
 * ****************************************************/

import java.util.Random;
import java.util.Scanner;

public class Ws1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Random r = new Random();
		int correct = r.nextInt(100) + 1;
		int count = 0;

		System.out.println("== Game Strat ==");
		
		while(true) {
			System.out.print("Input Number : ");
			int n = sc.nextInt();
			if(n <= 1 || n > 100) {
				System.out.println("Try Again!!");
				continue;
			}
			count++;
			if(n > correct) {
				System.out.println("It's too Big!");
			}
			else if(n < correct) {
				System.out.println("It's too Small!");
			} 
			else {
				System.out.printf("Correct!! You move %d Times!! \n\n", count);
				sc.close();
				break;	
			}
		}
	}
}

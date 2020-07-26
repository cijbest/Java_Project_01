package forwhile;
/*****************************************************
 * Number Guess Game
 * 1. 프로그램을 실행한다.
 * 2. 1~100 사이에 의의 정수가 자동 생성된다.
 * 3. 사용자는 1~100까지의 숫자를 입력한다.
 * 4. 입력한 값이 범위르 벗어나거나 문자가 입력되면 다시 입력 하라고 나온다.
 * 5. 입력한 숫자가 생성된 수보다 크면 크다
 *    작으면 작다라고 표시한다.
 * 6. 맞으면 정답이라고 표시한다.
 * 7. 진행 한 횟수를 표시한다.
 * 8. 정답을 맞추면 다시 시작을 눌러 게임을 다시 시작 한다.
 * 9. 정답을 맞춘 횟수를 표시 한다.
 * 
 * String str = "A"; char c = 'A'; char c2 = str.charAt(0); // c1 == c2 비교가 가능
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

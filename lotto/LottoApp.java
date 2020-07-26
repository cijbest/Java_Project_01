package lotto;

import java.util.Random;
import java.util.Scanner;

public class LottoApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "";
		Lotto lo = new Lotto();
		
		lo.setTotalPrice();
		int totalamount = lo.totalprize;
		// 1st : 50%, 2st: 30%, 3st: 10%, 4st: 8%, 5st: 2%
		System.out.println("-------------------Program Start-------------------");
		System.out.printf("1st prize amount is %.0f \n", totalamount * 0.5); // 소수점 자리 날림
		System.out.printf("2st prize amount is %.0f \n", totalamount * 0.3);// 소수점 자리 날림
		System.out.printf("3st prize amount is %.0f \n", totalamount * 0.3);// 소수점 자리 날림
		System.out.printf("4st prize amount is %.0f \n", totalamount * 0.08);// 소수점 자리 날림
		System.out.printf("5st prize amount is %.0f \n", totalamount * 0.02);// 소수점 자리 날림

		System.out.println("Input Menu: C(Check My Number), Q(Quit)");

		while (true) { // Program Start
			// LOTTO 숫자 생성(랜덤)
			lo.setAnswer();

			// 메뉴 구성
			s = sc.nextLine();

			if (s.equals("Q") || s.equals("q")) { // Quit Menu Selected -> Program Quit
				break;
			} else if (s.equals("C") || s.equals("c") || s.equals("R") || s.equals("r")) { // Check Menu Selected

				// 사용자 번호 입력
				int user[] = new int[6];
				out: while (true) {
					// 사용자 번호 입력
					System.out.println("1 ~ 45 사이의 숫자 6개를 입력해 주세요.");
					for (int i = 0; i < 6; i++) {
						user[i] = sc.nextInt();
					}
					sc.nextLine(); // 개행문자 제거 (nextInt 사용 시 개행문자가 남아 에러나는 것을 방지)

					// 사용자가 입력한 번호 검수
					for (int i = 0; i < 6; i++) {
						if (user[i] < 1 || user[i] > 45) {
							System.out.println("1 ~ 45 사이의 숫자만 입력해 주세요!");
							break;
						}
						if (i == 5) {
							break out;
						}
					}
				}

				// LOTTO 숫자와 사용자 숫자 비교
				lo.check(user);
				System.out.println("count : " + lo.count);

				// 등수 확인
				int count = lo.count;
				int lotto[] = lo.answer;
				if (count > 1) { // 당첨금 수급자에게만 번호 알림 표시
					System.out.print("금주의 Lotto번호 : ");
					for (int i = 0; i < 6; i++) {
						System.out.print(lotto[i] + " ");
					}
					System.out.println();
					System.out.print("나의 Lotto번호 : ");
					for (int i = 0; i < 6; i++) {
						System.out.print(user[i] + " ");
					}
					System.out.println();
				}
				
				if(lo.rank != 0) {
					lo.prize();
					System.out.printf("%d등 입니다. 상금은 %.0f 입니다.", lo.rank, lo.prize);
					break;
				}else {
					System.out.println("꽝!!");
					System.out.println("Input Menu: R(Retry Check My Number), Q(Quit)");
				}
				
			} else {
				System.out.println("Invalid Menu Selected"); // Invalid Menu Selected(Error)
			}
		}
		sc.close();
		System.out.println("---------Program completely Turned Off---------");

	}

}

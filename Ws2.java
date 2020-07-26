package str;

/*
1. 프로그램 요구사항
-Lotto 번호 랜덤 생성 (1부터 45까지의 수, 6개)
-총 상금 랜덤 생성 (1~100억)
-등수별 당첨금 안내
-메뉴 구성 (1. 게임시작, 2. 종료)
-당첨금 배분 규칙(고정, 1등:80%, 2등:15%, 3등:4%, 4등:0.9%, 5등:0.1%)
-사용자의 lotto 번호 입력
-번호의 당첨 여부 확인 (자리에 상관없이 1등 6개, 2등 5개, 3등 4개, 4등 3개, 5등 2개 일치)
-사용자의 번호에 따른 등수 안내 및 당첨금 지급
-당첨시 프로그램 종료
-미 당첨 시 번호 재 입력 또는 종료 선택
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ws {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Random r = new Random();
      String s = "";

      int totalamount = r.nextInt(1000000000) + 80000000; // 1 ~ 1.8 billion
      // 1st : 50%, 2st: 30%, 3st: 10%, 4st: 8%, 5st: 2%
      System.out.println("-------------------Program Start-------------------");
      System.out.printf("1st prize amount is %.0f \n", totalamount * 0.5); // 소수점 자리 날림
      System.out.printf("2st prize amount is %.0f \n", totalamount * 0.3);// 소수점 자리 날림
      System.out.printf("3st prize amount is %.0f \n", totalamount * 0.1);// 소수점 자리 날림
      System.out.printf("4st prize amount is %.0f \n", totalamount * 0.08);// 소수점 자리 날림
      System.out.printf("5st prize amount is %.0f \n", totalamount * 0.02);// 소수점 자리 날림
      
      System.out.println("Input Menu: C(Check My Number), Q(Quit)");

      while (true) { // Program Start
         // LOTTO 숫자 생성(랜덤)
         int lotto[] = new int[6];
         for (int i = 0; i < 6; i++) {
            lotto[i] = r.nextInt(45) + 1;
            if(i != 0) {
               for(int j = 0; j < i; j++) {
                  if(lotto[i] == lotto[j]) {
                     i--; // 앞으로 땡겨서 다시 입력받음 (i-- -> i++ 처리된 후 시작)
                     break;
                  }
               }
            }
         }

         // 메뉴 구성
         s = sc.nextLine();

         if (s.equals("Q") || s.equals("q")) { // Quit Menu Selected -> Program Quit
            break;
         } else if (s.equals("C") || s.equals("c") || s.equals("R") || s.equals("r")) { // Check Menu Selected
        	 
            // 사용자 번호 입력
        	int user[] = new int[6];
        	out:
        	while (true) {
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
					if(i == 5) {
						break out;
					}
				}
			}
        	
            // LOTTO 숫자와 사용자 숫자 비교
            int count = 0;
            for (int i = 0; i < 6; i++) {
               for (int j = 0; j < 6; j++) {
                  if (lotto[i] == user[i]) { // 맞는 숫자가 있을 때
                     count += 1;
                     break;
                  }
               }
            }
            System.out.println("count : " + count);

            // 등수 확인
            if(count > 1) { // 당첨금 수급자에게만 번호 알림 표시
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
            if (count == 6) { // 1등
               System.out.println("축하합니다! 1등에 당첨되셨습니다!");
               System.out.printf("당첨금은 %.0f원 입니다!!\n", totalamount * 0.5);
               break;
            } else if (count == 5) { // 2등
               System.out.println("축하합니다! 2등에 당첨되셨습니다!");
               System.out.printf("당첨금은 %.0f원 입니다!!\n", totalamount * 0.3);
               break;
            } else if (count == 4) { // 3등
               System.out.println("축하합니다! 3등에 당첨되셨습니다!");
               System.out.printf("당첨금은 %.0f원 입니다!!\n", totalamount * 0.1);
               break;
            } else if (count == 3) { // 4등
               System.out.println("축하합니다! 4등에 당첨되셨습니다!");
               System.out.printf("당첨금은 %.0f원 입니다!!\n", totalamount * 0.08);
               break;
            } else if (count == 2) { // 5등
               System.out.println("축하합니다! 5등에 당첨되셨습니다!");
               System.out.printf("당첨금은 %.0f원 입니다!!\n", totalamount * 0.02);
               break;
            } else { // 꽝
               System.out.println("아쉽지만 꽝입니다ㅠㅠ");
               System.out.println("다시 도전하시겠어요?");
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
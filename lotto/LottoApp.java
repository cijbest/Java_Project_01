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
		System.out.printf("1st prize amount is %.0f \n", totalamount * 0.5); // �Ҽ��� �ڸ� ����
		System.out.printf("2st prize amount is %.0f \n", totalamount * 0.3);// �Ҽ��� �ڸ� ����
		System.out.printf("3st prize amount is %.0f \n", totalamount * 0.3);// �Ҽ��� �ڸ� ����
		System.out.printf("4st prize amount is %.0f \n", totalamount * 0.08);// �Ҽ��� �ڸ� ����
		System.out.printf("5st prize amount is %.0f \n", totalamount * 0.02);// �Ҽ��� �ڸ� ����

		System.out.println("Input Menu: C(Check My Number), Q(Quit)");

		while (true) { // Program Start
			// LOTTO ���� ����(����)
			lo.setAnswer();

			// �޴� ����
			s = sc.nextLine();

			if (s.equals("Q") || s.equals("q")) { // Quit Menu Selected -> Program Quit
				break;
			} else if (s.equals("C") || s.equals("c") || s.equals("R") || s.equals("r")) { // Check Menu Selected

				// ����� ��ȣ �Է�
				int user[] = new int[6];
				out: while (true) {
					// ����� ��ȣ �Է�
					System.out.println("1 ~ 45 ������ ���� 6���� �Է��� �ּ���.");
					for (int i = 0; i < 6; i++) {
						user[i] = sc.nextInt();
					}
					sc.nextLine(); // ���๮�� ���� (nextInt ��� �� ���๮�ڰ� ���� �������� ���� ����)

					// ����ڰ� �Է��� ��ȣ �˼�
					for (int i = 0; i < 6; i++) {
						if (user[i] < 1 || user[i] > 45) {
							System.out.println("1 ~ 45 ������ ���ڸ� �Է��� �ּ���!");
							break;
						}
						if (i == 5) {
							break out;
						}
					}
				}

				// LOTTO ���ڿ� ����� ���� ��
				lo.check(user);
				System.out.println("count : " + lo.count);

				// ��� Ȯ��
				int count = lo.count;
				int lotto[] = lo.answer;
				if (count > 1) { // ��÷�� �����ڿ��Ը� ��ȣ �˸� ǥ��
					System.out.print("������ Lotto��ȣ : ");
					for (int i = 0; i < 6; i++) {
						System.out.print(lotto[i] + " ");
					}
					System.out.println();
					System.out.print("���� Lotto��ȣ : ");
					for (int i = 0; i < 6; i++) {
						System.out.print(user[i] + " ");
					}
					System.out.println();
				}
				
				if(lo.rank != 0) {
					lo.prize();
					System.out.printf("%d�� �Դϴ�. ����� %.0f �Դϴ�.", lo.rank, lo.prize);
					break;
				}else {
					System.out.println("��!!");
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

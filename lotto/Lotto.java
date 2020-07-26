package lotto;

import java.util.Random;

public class Lotto {
	int answer[] = new int[6];
	int rank;
	double prize;
	int totalprize;
	int count;
	
	Random r = new Random();

	public void setTotalPrice() {
		this.totalprize = r.nextInt(1000000000) + 80000000; // 1 ~ 1.8 billion
	}
	
	public void setAnswer() {
		for (int i = 0; i < 6; i++) {
			this.answer[i] = r.nextInt(45) + 1;
			if (i != 0) {
				for (int j = 0; j < i; j++) {
					if (answer[i] == answer[j]) {
						i--; // ������ ���ܼ� �ٽ� �Է¹��� (i-- -> i++ ó���� �� ����)
						break;
					}
				}
			}
		}
	}
	
	public void check(int[] user) {
		count = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (answer[i] == user[i]) { // �´� ���ڰ� ���� ��
					count += 1;
					break;
				}
			}
		}
		
		if (count == 6) { 
			rank = 1;
		} else if (count == 5) { // 2��
			rank = 2;
		} else if (count == 4) { // 3��
			rank = 3;
		} else if (count == 3) { // 4��
			rank = 4;
		} else if (count == 2) { // 5��
			rank = 5;
		} else { // ��
			rank = 0;
		}	
	}
	
	public void prize() {
		if (count == 6) { 
			prize = totalprize * 0.5;
		} else if (count == 5) { // 2��
			prize = totalprize * 0.32;
		} else if (count == 4) { // 3��
			prize = totalprize * 0.3;
		} else if (count == 3) { // 4��
			prize = totalprize * 0.08;
		} else if (count == 2) { // 5��
			prize = totalprize * 0.02;
		} else { // ��
			prize = 0;
		}
	}
	
}

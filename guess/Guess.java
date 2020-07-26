package guess;

public class Guess {
	
	int answer;
	int count;
	int totalCount;
	
	
	// 정답 셋팅
	public void setAnswer(int answer) {
		this.answer = answer;
		count = 0;
	}

	public boolean isRange(int input) {
		if(input >= 1 && input <= 100) {
            return true;
        }
		return false;
	}
	
	public String checkNum(int input) {
		count++;
		totalCount++;
		if (input > answer) {
			return "Big";
		} else if (input < answer) {
			return "Small";
		} else {
			return "Correct";
		}
	}
	

}

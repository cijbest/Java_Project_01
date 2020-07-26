package employee2;

public class App3 {

	public static void main(String[] args) {
		Employee es[] = new Employee[3];
		es[0] = new Employee("Seo", "00", 500, "M");
		es[1] = new Manager("Lee", "11", 500, "M", 100);
		es[2] = new Sales("Kim", "22", 500, "M", "Seoul", 100);

		for (int i = 0; i < es.length; i++) {
			//System.out.println(es[i]); // employee, manager, sales 각각의 객체의 정보가 보여짐
			System.out.println(es[i].annSalary()); // 하위 클래스에 오버라이딩 해놓은 함수에 접근
		}
	}

}

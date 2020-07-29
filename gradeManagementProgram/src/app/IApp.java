package app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

//import com.biz.UserDb;
import com.frame.Db;
import com.vo.Student;

public class IApp {

	Frame frame;
	Panel p1, p2, p3, sp1, sp2;
	Button b1, b2;
	TextField tf1, tf2, tf3, utf1, utf2, utf3;
	List list;
	Label label;

	Db<String, Student> studentDb;
	ArrayList<Student> slist;
	Student temp;

	public IApp() {

	}

	public IApp(Db<String, Student> studentDb) {
		this.studentDb = studentDb;
		makeUi();
		eventProcess();
	}

	public void makeUi() {
		frame = new Frame("Grade Management System for Instructors");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		utf1 = new TextField();
		utf2 = new TextField();
		b1 = new Button("Student Insert"); // Insert Button
		b2 = new Button("Score Update"); // Update Button

		label = new Label("STATUS : "); // Label 생성
		p3.setLayout(new BorderLayout());
		p3.add(label);

		sp1 = new Panel();
		sp2 = new Panel();
		sp1.setBackground(Color.pink); // Score 입력창 생성
		sp2.setLayout(new GridLayout(3, 1));
		sp2.add(utf1);
		sp2.add(utf2);
		sp2.add(b2);

		p1.add(tf1);
		p1.add(tf2);
		p1.add(tf3);
		p1.add(b1); // 맨 위 학생 입력 패널

		list = new List();
		list.setBackground(Color.orange);
		sp1.setLayout(new BorderLayout());
		sp1.add(list);

		p2.setLayout(new GridLayout(1, 2));
		p2.add(sp1);
		p2.add(sp2);

		p1.setBackground(Color.LIGHT_GRAY);
		p2.setBackground(Color.black);
		p3.setBackground(Color.green);

		frame.add(p1, "North");
		frame.add(p2, "Center");
		frame.add(p3, "South");

		frame.setSize(800, 500);
		frame.setLocation(400, 400);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				selectStudent();

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) { // x표시 버튼 눌렀을 때 이벤트를 처리
				frame.setVisible(false);
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		frame.setVisible(true);

	}

	public void eventProcess() {
		// insert button
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				insertStudent();
			}
		});

		// update button
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateStudent();
			}
		});

		list.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = list.getSelectedIndex();
				Student student = slist.get(index);
				utf1.setText(student.getName());
				utf2.setText(student.getScore() + "");
				temp = student;
			}
		});

	}

	public void setLabel(String str) {
		label.setText("STATUS : " + str);
	}

	// 점수와 계산된 학점을 업데이트
	public void updateStudent() {
		double score = Double.parseDouble(utf2.getText());
		String grade = gradeSet(score);
		temp.setScore(score);
		temp.setGrade(grade);
		//System.out.println("temp : " + temp);
		try {
			studentDb.update(temp);
			selectStudent();
			setLabel("Update Completed !!");
		} catch (Exception e) {
			setLabel("Update Fail !!");
		}
	}

	// 선생님이 입력한 점수에 따른 학점 계산
	public String gradeSet(double score) {
		String grade = null;
		if (score >= 95) {
			grade = "A+";
		} else if (score >= 90) {
			grade = "A";
		} else if (score >= 85) {
			grade = "B+";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 75) {
			grade = "C+";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 65) {
			grade = "D+";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
	}

	public void insertStudent() {
		String id = tf1.getText();
		String pwd = tf2.getText();
		String name = tf3.getText();

		Student student = new Student(id, pwd, name);
		try {
			studentDb.insert(student);
			selectStudent();
			setLabel("Insert Completed !!");
		} catch (Exception e) {
			setLabel("Insert Fail !!");
		}
	}

	public void selectStudent() {
		try {
			slist = studentDb.select();
			list.removeAll();
			for (Student s : slist) {
				list.add(s.getName() + " " + s.getScore() + " " + s.getGrade());
			}
			setLabel("Search Completed !!");
		} catch (Exception e) {
			setLabel("Search Fail !!");
		}
	}
//	public static void main(String[] args) {
//		IApp app = new IApp();
//		
//		
//	}

}

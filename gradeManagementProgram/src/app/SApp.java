package app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import com.frame.Db;
import com.vo.Student;

public class SApp {
	Frame frame;
	Panel p1, p2, p3, sp1, sp2;
	Button b1;
	Label label;
	List list1, list2; // list1 - 학생 정보 출력, list2 - 학생 학점 출력
	Font font1 = new Font("Serif", Font.PLAIN, 20);
	Font font2 = new Font("Serif", Font.BOLD, 80);


	Db<String, Student> studentDb;
	ArrayList<Student> slist;

	Student s;
	String key; // 로그인한 사용자의 id를 받아오는 변수

	public SApp() {
	}

	public SApp(Db<String, Student> studentDb, String key) {
		this.studentDb = studentDb;
		this.key = key;
		makeUi();
		eventProcess();
	}

	public void makeUi() {
		frame = new Frame("Grade Checking System for Students");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		b1 = new Button("Refresh"); // 새로고침 버튼
		label = new Label("Status: ");

		p1.add(b1);
		p3.setLayout(new BorderLayout());
		p3.add(label);

		sp1 = new Panel();
		sp2 = new Panel();
		list1 = new List();
		list1.setBackground(Color.orange);

		list2 = new List();
		list2.setBackground(Color.pink);

		sp1.setLayout(new BorderLayout());
		sp1.add(list1);
		sp2.setLayout(new BorderLayout());
		sp2.add(list2);

		p2.setLayout(new GridLayout(1, 2));
		p2.add(sp1);
		p2.add(sp2);

		frame.add(p1, "North");
		frame.add(p2, "Center");
		frame.add(p3, "South");

		frame.setSize(800, 500);
		frame.setLocation(400, 400);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				selectStudent(key);

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
		list1.setFont(font1);
	    list2.setFont(font2);


	}

	public void eventProcess() {

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectStudent(key);
			}
		});
	}

	public void setLabel(String str) {
		label.setText("STATUS : " + str);
	}

	public void selectStudent(String key) {
		try {
			s = studentDb.select(key);
			list1.removeAll();
			list2.removeAll();
			list1.add(s.getId() + " " + s.getName() + " " + s.getScore());
			list2.add("Grade: " + s.getGrade());
			setLabel("Search Completed !!");
		} catch (Exception e) {
			setLabel("Search Fail !!");
			e.printStackTrace();
		}
	}

}
package com.gmail.gor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JOptionPane;

import com.gmail.gor.exceptions.NotEnoughSpaceException;

public class Group implements Voencom,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student[] students = new Student[10];
	private String groupName;

	public Group(Student[] students, String groupName) {
		super();
		this.students = students;
		this.groupName = groupName;
	}

	public Group() {
		super();
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudens(Student[] students) {
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void deleteStudent(long id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getId() == id) {
				students[i] = null;
			}
		}
	}

	public Student searchStudent(String lastName) {
		for (Student student : students) {
			if (student != null && student.getLastName().equalsIgnoreCase(lastName)) {
				return student;

			}
		}
		return null;
	}

	public void addStudent(Student st) throws NotEnoughSpaceException {
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = st;
				students[i].setGroup(groupName);
				count++;
				break;
			}
		}
		if (count == 0)
			throw new NotEnoughSpaceException();
	}

	public void createStudent() throws NotEnoughSpaceException {

		try {
			String name = JOptionPane.showInputDialog("Input name");
			String lastName = JOptionPane.showInputDialog("Input lastName");
			Gender gender = createGender();
			int age = createAge();
			long id = createId();
			Student student = new Student(name, lastName, gender, age, id);
			this.addStudent(student);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Cancel");
		}
	}

	public Gender createGender() {
		Gender gender;
		for (;;) {
			try {
				gender = Gender.valueOf(JOptionPane.showInputDialog("Input gender"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Error");
			}

		}
		return gender;
	}

	public int createAge() {
		int age;
		for (;;) {
			try {
				age = Integer.valueOf(JOptionPane.showInputDialog("Input age"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error");
			}

		}
		return age;

	}

	public long createId() {
		long id;
		for (;;) {
			try {
				id = Long.valueOf(JOptionPane.showInputDialog("Input id"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error");
			}

		}
		return id;

	}

	@Override
	public Student[] getReacruter() {
		int arrSize = 0;

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getAge() > 18 && students[i].getGender() == Gender.MAN) {
				arrSize += 1;
			}
		}
		Student[] reacruter = new Student[arrSize];
		int arrnumber = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getAge() > 18 && students[i].getGender() == Gender.MAN) {
				reacruter[arrnumber] = students[i];
				arrnumber += 1;
			}

		}
		return reacruter;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + Arrays.hashCode(students);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (!Arrays.equals(students, other.students))
			return false;
		return true;
	}

	@Override
	public String toString() {
		Arrays.sort(students, Comparator.nullsFirst(new StudentLastNameComparator()));

		String string = "Group- " + groupName + System.lineSeparator();
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				string += students[i] + System.lineSeparator();
			}
		}
		return string;
	}
	

}

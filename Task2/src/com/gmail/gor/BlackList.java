package com.gmail.gor;

import java.util.Arrays;

public class BlackList {
	private Class<?>[] classes = new Class<?>[100];

	public BlackList() {
		super();
	}

	public void addToBlackList(Class<?> a) {
		for (int i = 0; i < classes.length; i++) {
			if (classes[i] == null) {
				classes[i] = a;
				break;
			}
		}
	}

	public void deleteToBlackList(Class<?> a) {
		for (int i = 0; i < classes.length; i++) {
			if (classes[i] == a) {
				classes[i] = null;
			}else {
				System.out.println("no place in the blacklist");
			}
		}
	}

	public boolean verification(Object obj) {

		for (int i = 0; i < classes.length; i++) {
			if (obj.getClass() == classes[i]) {

				return false;
			}

		}

		return true;

	}

	@Override
	public String toString() {
		return "BlackList [classes=" + Arrays.toString(classes) + "]";
	}

}

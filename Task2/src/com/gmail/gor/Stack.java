package com.gmail.gor;

import java.util.Arrays;

public class Stack {
	private Object[] object = new Object[0];
	private BlackList blackList;

	public Stack() {
		super();
	}

	public Stack(BlackList blackList) {
		super();
		this.blackList = blackList;
	}

	public BlackList getBlackList() {
		return blackList;
	}

	public void setBlackList(BlackList blackList) {
		this.blackList = blackList;
	}

	public void addObject(Object a) {
		if (blackList.verification(a)) {
			if (object.length == 0) {
				firstelement(a);
			} else {
				Object[] b = new Object[object.length + 1];
				System.arraycopy(object, 0, b, 0, object.length);
				b[b.length - 1] = a;
				object = b;

			}
		} else
			System.out.println("the class of this object is blacklisted");
	}

	public void firstelement(Object a) {
		object = new Object[1];
		object[0] = a;

	}

	public Object takeElementsDelete() {
		if (object.length > 0) {
			Object[] b = new Object[object.length - 1];
			System.arraycopy(object, 0, b, 0, b.length);
			Object a = object[object.length - 1];
			object = b;
			return a;
		} else {
			System.out.println("not found element");
			return null;
		}
	}

	public Object takeElements() {
		if (object.length > 0) {
			Object a = object[object.length - 1];
			return a;
		} else {
			System.out.println("not found element");
			return null;
		}
	}

	@Override
	public String toString() {
		return "Stack [object=" + Arrays.toString(object) + "]";
	}

}

package com.gmail.gor;

public class Main {

	public static void main(String[] args) {
		BlackList black = new BlackList();

		black.addToBlackList(Integer.class);
		black.addToBlackList(String.class);
		black.deleteFromBlackList(String.class);
		black.addToBlackList(Integer.class);
		Stack stack = new Stack(black);
		stack.addObject(11);
		stack.addObject(11L);
		stack.addObject("last word");
		

		System.out.println(stack.takeElementsDelete());
		System.out.println(stack.takeElementsDelete());
		System.out.println(stack.takeElementsDelete());

		System.out.println(stack);
		System.out.println(black);

	}

}

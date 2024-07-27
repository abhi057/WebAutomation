package practice;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

public class ArrayListDemo {

	@Test
	public void ArrayListTest() {

		System.out.println("Test");

		String[] str = { "nmn", "jhjhj", "iuuiu" };
		
		ArrayList<String> myArrList = new ArrayList<String>();
		
		Collections.addAll(myArrList, str);
		
		myArrList.add("Abhi");
		
		System.out.println(myArrList);

		for (String s : myArrList) {

			System.out.println(s);

		}
	}
}

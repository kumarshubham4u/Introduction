import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {

	// Count the number of names starting with S in a list

	@Test
	public void regular() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Shubham");
		names.add("Manya");
		names.add("Shruti");
		names.add("Kushal");
		names.add("Samiran");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {

			if (names.get(i).startsWith("S")) {
				count++;
			}

			System.out.println(count);
		}

	}

	@Test
	public void test2() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Shubham");
		names.add("Manya");
		names.add("Shruti");
		names.add("Kushal");
		names.add("Samiran");

		long c = names.stream().filter(s -> s.startsWith("S")).count();

		System.out.println(c);
	}

	@Test
	public void test3() {
		
		ArrayList<String> names= new ArrayList<String>();
		
		names.add("Shubham");
		names.add("Manya");
		names.add("Shruti");
		names.add("Kushal");
		names.add("Samiran");
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		
	}

	@Test
	public void test4() {

		Stream.of("Shubham", "Manya", "Shruti", "Abijeet", "Rama").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

	}

	@Test
	public void test5() {

		Stream.of("Shubham", "Manya", "Shruti", "Abijeet", "Rama").filter(s -> s.endsWith("S")).sorted()
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

	}
	
	@Test
	public void test6() {
		ArrayList<String> names1= new ArrayList<String>();
		
		names1.add("Shubham");
		names1.add("Manya");
		names1.add("Shruti");
		names1.add("Kushal");
		names1.add("Samiran");
		
		
		List<String> names2 = Arrays.asList("Sam","Kumar","Roshan");
	
		Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
		
		newStream.sorted().forEach(s->System.out.println(s));
		
		

	}
	
	@Test
	public void test7() {
		
		ArrayList<String> names= new ArrayList<String>();
		
		names.add("Shubham");
		names.add("Manya");
		names.add("Shruti");
		names.add("Kushal");
		names.add("Samiran");
		
		boolean flag= names.stream().anyMatch(s->s.equalsIgnoreCase("manya"));
		Assert.assertTrue(flag );
		
		
	}


}

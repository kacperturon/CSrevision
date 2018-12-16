package thinkDAST.unitTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import thinkDAST.MyListInterface;
import thinkDAST.rev12.MyArrayList;

public class MyArrayListTest {
	protected MyListInterface<Integer> mylist;
	protected List<Integer> list;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		mylist = new MyArrayList<Integer>();
		mylist.addAll(list);
	}

	@Test
	public void testMyList() {
		assertThat(mylist.size(), is(3));
	}

	@Test
	public void testAddT() {
		for (int i = 4; i < 20; i++) {
			mylist.add(i);
		}
		assertThat(mylist.get(18), is(new Integer(19)));
	}

	@Test
	public void testAddIntT() {
		mylist.add(1, 5);
//		System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mylist.get(1), is(new Integer(5)));
		assertThat(mylist.size(), is(4));

		try {
		    mylist.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mylist.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		mylist.add(0, 6);
//		System.out.println(Arrays.toString(mylist.toArray()));
		assertThat(mylist.get(0), is(6));

		mylist.add(4, 7);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mylist.get(4), is(new Integer(7)));
	}

	@Test
	public void testGet() {
		assertThat(mylist.get(1), is(new Integer(2)));
	}

	@Test
	public void testIndexOf() {
		assertThat(mylist.indexOf(3), is(2));
		assertThat(mylist.indexOf(4), is(-1));
	}

	@Test
	public void testIndexOfNull() {
		assertThat(mylist.indexOf(null), is(-1));
		mylist.add(null);
		assertThat(mylist.indexOf(null), is(3));
	}

	@Test
	public void testRemoveObject() {
		boolean flag = mylist.remove(new Integer(2));
		assertThat(flag, equalTo(true));
		assertThat(mylist.size(), is(2));
		assertThat(mylist.get(1), is(new Integer(3)));

	}

	@Test
	public void testRemoveInt() {
		Integer val = mylist.remove(1);
		assertThat(val, is(new Integer(2)));
		assertThat(mylist.size(), is(2));
		assertThat(mylist.get(1), is(new Integer(3)));
	}


	@Test
	public void testSet() {
		Integer val = mylist.set(1, 5);
		assertThat(val, is(new Integer(2)));

		val = mylist.set(0, 6);
		assertThat(val, is(new Integer(1)));

		val = mylist.set(2, 7);
		assertThat(val, is(new Integer(3)));

		// return value should be 2
		// list should be [6, 5, 7]
		assertThat(mylist.get(0), is(new Integer(6)));
		assertThat(mylist.get(1), is(new Integer(5)));
		assertThat(mylist.get(2), is(new Integer(7)));
		//System.out.println(Arrays.toString(mal.toArray()));

		try {
		    mylist.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mylist.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good
	}
}

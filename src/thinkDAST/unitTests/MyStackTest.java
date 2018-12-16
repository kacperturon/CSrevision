package thinkDAST.unitTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import thinkDAST.rev11.MyStack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MyStackTest {
	
	MyStack stack;
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

	}

	@Test
	public void testMyList() {
		assertThat(stack.size(), is(3));
		assertThat(stack.isEmpty(), is(false));
	}

	@Test
	public void testPushT() {
		for (int i = 4; i < 20; i++) {
			stack.push(i);
		}
		assertThat(stack.isEmpty(), is(false));
		assertThat(stack.size(), is(19));
	}
	@Test
	public void testPeekT() {
		assertThat(stack.size(), is(3));
		assertEquals(stack.peek(), stack.head.data);
		assertThat(stack.size(), is(3));

	}
	
	@Test
	public void testPopT() {
		assertThat(stack.size(), is(3));
		assertNotEquals(stack.pop(), stack.head.data);
		assertThat(stack.size(), is(2));
		
	}
	
	@Test
	public void testIsEmpty() {
		assertThat(stack.isEmpty(), is(false));
		stack.pop();
		stack.pop();
		stack.pop();
		assertThat(stack.isEmpty(), is(true));
	}
	

}

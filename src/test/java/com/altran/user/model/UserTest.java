/**
 * 
 */
package com.altran.user.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 4013707
 *
 */
class UserTest {

	private User user;
	private User user1;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		user = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
		user1 = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Test Completed");
	}


	
	/**
	 * Test method for {@link com.altran.user.model.User#getUserId()}.
	 */
	@Test
	void testGetUserId() {
		//given
		User pojo = new User();

		//when
		pojo.setUserId(1);

		//then
		assertTrue(pojo.getUserId()==1);
	}

	/**
	 * Test method for {@link com.altran.user.model.User#getUserName()}.
	 */
	@Test
	void testGetUserName() {
		//given
		User pojo = new User();

		//when
		pojo.setUserName("amvabhijith");

		//then
		assertTrue(pojo.getUserName().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		User pojo = new User();

		//when
		pojo.setPassword("amvabhijith");

		//then
		assertTrue(pojo.getPassword().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#getPasswordConfirm()}.
	 */
	@Test
	void testGetPasswordConfirm() {
		User pojo = new User();

		//when
		pojo.setPasswordConfirm("amvabhijith");

		//then
		assertTrue(pojo.getPasswordConfirm().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#getFirstName()}.
	 */
	@Test
	void testGetFirstName() {
		User pojo = new User();

		//when
		pojo.setFirstName("amvabhijith");

		//then
		assertTrue(pojo.getFirstName().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#getLastName()}.
	 */
	@Test
	void testGetLastName() {
		User pojo = new User();

		//when
		pojo.setLastName("amvabhijith");

		//then
		assertTrue(pojo.getLastName().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#setUserId(long)}.
	 */
	@Test
	void testSetUserId() {
		//given
		User pojo = new User();

		//when
		pojo.setUserId(1);

		//then
		assertTrue(pojo.getUserId()==1);
	}

	/**
	 * Test method for {@link com.altran.user.model.User#setUserName(java.lang.String)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	void testSetUserName(){
		//given
		User pojo = new User();

		//when
		pojo.setUserName("amvabhijith");

		//then
		assertTrue(pojo.getUserName().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#setPassword(java.lang.String)}.
	 */
	@Test
	void testSetPassword() {
		User pojo = new User();

		//when
		pojo.setPassword("amvabhijith");

		//then
		assertTrue(pojo.getPassword().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#setPasswordConfirm(java.lang.String)}.
	 */
	@Test
	void testSetPasswordConfirm() {
		User pojo = new User();

		//when
		pojo.setPasswordConfirm("amvabhijith");

		//then
		assertTrue(pojo.getPasswordConfirm().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#setFirstName(java.lang.String)}.
	 */
	@Test
	void testSetFirstName() {
		User pojo = new User();

		//when
		pojo.setFirstName("amvabhijith");

		//then
		assertTrue(pojo.getFirstName().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#setLastName(java.lang.String)}.
	 */
	@Test
	void testSetLastName() {
		User pojo = new User();

		//when
		pojo.setLastName("amvabhijith");

		//then
		assertTrue(pojo.getLastName().equals("amvabhijith"));
	}

	/**
	 * Test method for {@link com.altran.user.model.User#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		User user1 = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
		User user2 = new User(1, "amvabhijith", "pass123","pass123","abhijith","am");
		assertEquals(user1, user2);
		assertTrue( user1.hashCode()==user2.hashCode() );
	}

}

package com.keane.JUnitTesting;

import static org.junit.Assert.*;
import org.junit.Test;

import com.keane.validation.Validation;

public class TestingJUnit {
	
	Validation v=new Validation();
	
	 @Test
	 	public void testgetStud_is() {
		 assertEquals(true,v.isvalidStud_id("123"));
	 }

	 @Test
	 	public void testgetEmail() {
		 assertEquals(true,v.isvalidEmail("mihir@ntt.com"));
	 }
	 
	 @Test
	 	public void testgetNseats() {
		 assertEquals(true,v.isvalidNseats(1000));
	 }
	 
	 @Test
	 	public void testgetNfaculty() {
		 assertEquals(true,v.isvalidNfaculty(50));
	 }
	
}

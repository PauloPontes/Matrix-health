package com.bridges.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.bridges.model.Action;
import com.bridges.model.Authorization;

public class ParserTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testParseAuthorization() {
		
		//Vector<Authorization> auth = Authoriation.parseAuthorization(new File("C:\\Users\\y0qd\\Desktop\\PEP"));
		//assertEquals("", 24854, auth.size());
		
		//	fail("não carregou as autorizações");
		
	}
	
	@Test
	public final void testEqualAction(){
		Action act1 = new Action("ABCD","ABCDa",true);
		Action act2 = new Action("ABCD","ABCDa",true);
		System.out.println(act1.equals(act2));
		assertEquals("erro", act1,act2);
		
	}
	

}

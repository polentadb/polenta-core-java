package com.polenta.core.executor.impl;

import com.polenta.core.data.DataType;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateCommandTest {

	@Test
	public void testCreateBagExtractDefinitions() throws Exception {
		CreateExecutor command = new CreateExecutor();
		
		Map<String, DataType> map = command.extractObjectDefinitions("CREATE BAG (NAME STRING, BIRTH DATE, ZIP INTEGER, SALARY DOUBLE)");
		
		assertEquals(4, map.size());
		
		assertTrue(map.containsKey("NAME"));
		assertTrue(map.containsKey("BIRTH"));
		assertTrue(map.containsKey("ZIP"));
		assertTrue(map.containsKey("SALARY"));
		
		assertEquals(DataType.STRING, map.get("NAME"));
		assertEquals(DataType.DATE, map.get("BIRTH"));
		assertEquals(DataType.INTEGER, map.get("ZIP"));
		assertEquals(DataType.DOUBLE, map.get("SALARY"));
	}
	
}

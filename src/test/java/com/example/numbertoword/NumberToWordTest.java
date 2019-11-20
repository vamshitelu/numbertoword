package com.example.numbertoword;

import java.io.BufferedReader;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit test for simple App.
 */

public class NumberToWordTest{
 
	@Test
	public  void oneTest() throws Exception {
		
		BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
		Mockito.when(bufferedReader.readLine()).thenReturn("");
		
		NumberToWord.main(new String[] {});
	}
}

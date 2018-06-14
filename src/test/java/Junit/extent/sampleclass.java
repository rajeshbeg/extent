package Junit.extent;

import static org.junit.Assert.*;
import org.junit.Test;


public class sampleclass extends BaseTest{
	@Test
	public void firstClass(){
	assertTrue(true);
	}
	@Test
	public void SeconClass(){
	assertFalse(false);
	}

}

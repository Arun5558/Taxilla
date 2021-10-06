package com.selenium.DataDriven.TestCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Deptest {
  @Test
  
  
  public void a() {
	  System.out.println("a");
	  //Assert.assertTrue(arg0, arg1);
	  Assert.assertTrue(false);
	  
  }
@Test(priority=1,dependsOnMethods="a")
  
  
  public void b() {
	 System.out.println("b");
  }
@Test(priority=2,dependsOnMethods="b")


public void c() {
	 System.out.println("c"); 
}
@Test(priority=3,dependsOnMethods="c")


public void d() {
	 System.out.println("d"); 
}
@Test(priority=4,dependsOnMethods="a")


public void e() {
	 System.out.println("e");  
}
}

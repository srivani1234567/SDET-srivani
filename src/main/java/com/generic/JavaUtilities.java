package com.generic;

import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	/*
	 * @Author SRIVANI
	 * give the Random number
	 * return RandomNumber
	 * @parameter pass number limit
	 * 
	 */
	
	public int getrandomnum(int num) {
		Random r=new Random();
		 int n1 = r.nextInt(num);
		 return n1;

	}
	
	/*
	 * @Author Srivani
	 * provide current Systemdate
	 * return currentSystem date
	 */
	public String getcurrentSystemdate() {
		Date dobj=new Date();
		String currentSysdate = dobj.toString();
		return currentSysdate;
		
	}
	
	/*
	 * @Author Srivani
	 * provide current System month
	 * return current System month
	 */
	public int getcurrentmonth() {
		Date dobj=new Date();
		int month = dobj.getMonth();
		return month;
	}
	
	/*
	 * @Author Srivani
	 * provide current date
	 * return date
	 */
      public String getcurrentdate() {
    	  Date dobj=new Date();
    	  String currentdate = dobj.toString();
    	   String[] arr = currentdate.split("");
    	   return arr[2];
      }
}

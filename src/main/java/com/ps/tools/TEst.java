package com.ps.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TEst {

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		DateFormat df=new SimpleDateFormat("yyyyMMDDHHmmss");
		String d=df.format(date);
		System.out.println(d);
	}

}

package org.testing.assertion;

public class assetions {
public static Boolean assertttt(String expected,String actual) {
	if(expected.equals(actual))
	// equal indicates whether some other object is "equal to" this one.
	{
		System.out.println("assertion is getting paassed");
		System.out.println("actual url is :- "+actual);
		System.out.println("actual url is :- "+expected);
		return true;
	}
	else
	{
		System.out.println("assertion is not getting passed ");
		System.out.println("actual url is :- "+actual);
		System.out.println("actual url is :- "+expected);
		return false;
		
	}
}
}

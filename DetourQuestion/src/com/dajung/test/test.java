package com.dajung.test;

import com.dajung.challenge.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetourCalculator detourCalculator = new DetourCalculator();
		Point departA = new Point(22, -21);
		Point destA = new Point(10, 11);
		Point departB = new Point(13, 21);
		Point destB = new Point(-30, 19);
		Driver d1 = new Driver(departA, destA);
		Driver d2 = new Driver(departB, destB);
		
		System.out.println("Shorter Detour between driver one and two is : " + detourCalculator.calcDetourDistance(d1, d2));
	}

}

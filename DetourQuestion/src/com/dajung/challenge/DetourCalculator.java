package com.dajung.challenge;


public class DetourCalculator {

	/*
	 * A->C->D->B or C->A->B->D
	 * Either way, we have to calculate A-C and B-D Distance.
	 * Assuming that direction does not affect to the distance, 
	 * we can calculate A-C, B-D once.
	 */
	public double calcDetourDistance(Driver d1, Driver d2){
		double firstDistance = calcPointToPointDist(d1.getDeparture(), d2.getDeparture());
		double lastDistance = calcPointToPointDist(d1.getDestination(), d2.getDestination());
		double midDistance = 
				min( calcPointToPointDist(d1.getDeparture(), d1.getDestination()) ,
						calcPointToPointDist(d2.getDeparture(), d2.getDestination()));
		double detourDist = firstDistance + lastDistance + midDistance;
		
		return detourDist;
	}

	private double min(double X, double Y){
		if( X > Y ) return Y;
		return X;
	}
	
	
	/*
	 * 	Calculation of real distance between two pairs of longitude and latitude;
	 * 	Formula from http://www.movable-type.co.uk/scripts/latlong.html
	 *	formula:	a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
	 *	c = 2 ⋅ atan2( √a, √(1−a) )
	 *	d = R ⋅ c
	 */
	
	
	private double calcPointToPointDist(Point X, Point Y){
	
		double dDistance = 0;
		double dLat1 = Math.toRadians(X.getLatitude());
		double dLong1 = Math.toRadians(X.getLongitude());
		double dLat2 = Math.toRadians(Y.getLatitude());
		double dLong2 = Math.toRadians(Y.getLongitude());
		double dLongitude = dLong2 - dLong1;
		double dLatitude = dLat2 - dLat2;
		
		double a = Math.pow(Math.sin(dLatitude/2.0), 2.0)
				+ Math.cos(dLat1) * Math.cos(dLat1)
				* Math.pow(Math.sin(dLongitude/2.0), 2.0);
		double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0-a));
		double R = 6376.5;
		dDistance = R * c;
		return dDistance;
		
	}
}

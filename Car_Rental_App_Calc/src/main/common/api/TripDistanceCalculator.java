package common.api;

import java.util.List;

import common.data.Trip;

/**
 * Trip distance calculator. 
 */
public interface TripDistanceCalculator {
	
	/**
	 * Method to calculate trip distance in KM for given trip.
	 *  
	 * @param trip
	 * @return distance in KM
	 */
	double getTripDistance(Trip trip);

	/**
	 * Method to calculate trip distance in KM for given list of trips.
	 *  
	 * @param trips
	 * @return distance in KM
	 */
	double getTripDistance(List<Trip> trips);
}

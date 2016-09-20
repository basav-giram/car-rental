package common.api;

import java.util.List;

import common.data.Money;
import common.data.Trip;
import common.data.Vehicle;

/**
 * Trip cost calculator API.
 */
public interface TripCostCalculator {
	
	/**
	 * Method to calculate multiple trip cost.
	 * 
	 * @param vehicle
	 * @param trips
	 * @param numberOfPassengers
	 * @return total trip cost.
	 */
	Money calculateTripCost(Vehicle vehicle, List<Trip> trips, int numberOfPassengers);
	
	/**
	 * Method to calculate single trip cost.
	 * 
	 * @param vehicle
	 * @param trip
	 * @param numberOfPassengers
	 * @return total trip cost.
	 */
	Money calculateTripCost(Vehicle vehicle, Trip trip, int numberOfPassengers);
	
}

/**
 * 
 */
package common.api;

import common.data.Money;
import common.data.Vehicle;

/**
 * Vehicle Charge per KM calculator API.
 */
public interface VehicleCostCalculator {
	
	/**
	 * Method to calculate vehicle charge per KM.
	 * 
	 * @param vehicle
	 * @param numberOfPassengers
	 * @return Vehicle charge per KM
	 */
	Money getChargePerKm(Vehicle vehicle, int numberOfPassengers);
	
}

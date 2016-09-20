package common.api.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import common.api.TripCostCalculator;
import common.api.TripDistanceCalculator;
import common.api.VehicleCostCalculator;
import common.data.Money;
import common.data.Trip;
import common.data.Vehicle;

public class TripCostCalculatorImpl implements TripCostCalculator {

	private VehicleCostCalculator vehicleCostCalculator;

	private TripDistanceCalculator tripDistanceCalculator;
	
	public TripCostCalculatorImpl(VehicleCostCalculator vehicleCostCalculator,
			TripDistanceCalculator tripDistanceCalculator) {
		super();
		this.vehicleCostCalculator = vehicleCostCalculator;
		this.tripDistanceCalculator = tripDistanceCalculator;
	}

	@Override
	public Money calculateTripCost(Vehicle vehicle, Trip trip,
			int numberOfPassengers) {

		Money chargePerKM = vehicleCostCalculator.getChargePerKm(vehicle,
				numberOfPassengers);

		BigDecimal amount = chargePerKM.getAmount().multiply(
				BigDecimal.valueOf(tripDistanceCalculator.getTripDistance(trip)),
				new MathContext(15, RoundingMode.HALF_EVEN));
		return new Money(chargePerKM.getCurrency(), amount);
	}

	@Override
	public Money calculateTripCost(Vehicle vehicle, List<Trip> trips,
			int numberOfPassengers) {

		Money chargePerKM = vehicleCostCalculator.getChargePerKm(vehicle,
				numberOfPassengers);

		BigDecimal amount = chargePerKM.getAmount().multiply(
				new BigDecimal(tripDistanceCalculator.getTripDistance(trips)),
				new MathContext(15, RoundingMode.HALF_EVEN));
		return new Money(chargePerKM.getCurrency(), amount);
	}

}

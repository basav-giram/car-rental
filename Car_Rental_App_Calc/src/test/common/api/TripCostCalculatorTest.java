package common.api;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import common.api.impl.TripCostCalculatorImpl;
import common.api.impl.TripDistanceCalculatorImpl;
import common.api.impl.VehicleCostCalculatorImpl;
import common.data.Money;
import common.data.Trip;
import common.data.Vehicle;
import common.data.types.CurrencyCode;
import common.data.types.Destination;
import common.data.types.VehicleType;

public class TripCostCalculatorTest {

	TripCostCalculator calculator;
	
	@Before
	public void setUp() throws Exception {
		calculator = new TripCostCalculatorImpl(new VehicleCostCalculatorImpl(), new TripDistanceCalculatorImpl());
	}

	@Test
	public void testCalculateSingleTripCost() {
		Vehicle car = new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(10)), false, false, 3);
		Trip trip = new Trip(Destination.Pune, Destination.Mumbai);
		
		Money tripCost = calculator.calculateTripCost(car, trip, 3);
		assertEquals(new Money(CurrencyCode.INR, BigDecimal.valueOf(2000.0)), tripCost);
		
		tripCost = calculator.calculateTripCost(car, trip, 5);
		assertEquals(new Money(CurrencyCode.INR, BigDecimal.valueOf(2400.0)), tripCost);
	}
	
	@Test
	public void testCalculateMultipleTripCost() {
		Vehicle car = new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(10)), false, false, 3);
		List<Trip> trips = new ArrayList<Trip>();
		trips.add(new Trip(Destination.Pune, Destination.Mumbai));
		trips.add(new Trip(Destination.Mumbai, Destination.Delhi));
		
		Money tripCost = calculator.calculateTripCost(car, trips, 3);
		assertEquals(new Money(CurrencyCode.INR, BigDecimal.valueOf(22500)), tripCost);
		
		tripCost = calculator.calculateTripCost(car, trips, 5);
		assertEquals(new Money(CurrencyCode.INR, BigDecimal.valueOf(27000)), tripCost);
	}

}

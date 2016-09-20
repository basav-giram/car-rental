package common.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import common.api.impl.TripDistanceCalculatorImpl;
import common.data.Trip;
import common.data.types.Destination;

public class TripDistanceCalculatorTest {

	TripDistanceCalculator calculator; 
	
	@Before
	public void setUp() {
		calculator = new TripDistanceCalculatorImpl();
	}

	@Test
	public void testGetTripDistance() {		
		assertEquals(200, calculator.getTripDistance(new Trip(Destination.Pune, Destination.Mumbai)), 0.0);		
		assertEquals(200, calculator.getTripDistance(new Trip(Destination.Mumbai, Destination.Pune)), 0.0);
	}

	@Test
	public void testMultiTripDistance() {
		List<Trip> trips = new ArrayList<Trip>();
		trips.add(new Trip(Destination.Pune, Destination.Mumbai));
		trips.add(new Trip(Destination.Mumbai, Destination.Delhi));
		assertEquals(2250, calculator.getTripDistance(trips), 0.0);		
	}
}

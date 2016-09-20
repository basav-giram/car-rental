package common.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.api.TripDistanceCalculator;
import common.data.Trip;
import common.data.types.Destination;

public class TripDistanceCalculatorImpl implements TripDistanceCalculator {

	private Map<Trip, Double> distanceMap = new HashMap<Trip, Double>();

	public TripDistanceCalculatorImpl() {

		/*
		 * Pune - Mumbai: 200 KM 
		 * Pune - Bangalore: 1000 KM 
		 * Mumbai - Delhi: 2050 KM 
		 * Mumbai - Chennai: 1234.5 KM
		 */
		distanceMap.put(new Trip(Destination.Pune, Destination.Mumbai), 200.0);
		distanceMap.put(new Trip(Destination.Pune, Destination.Bangalore), 1000.0);
		distanceMap.put(new Trip(Destination.Mumbai, Destination.Delhi), 2050.0);
		distanceMap.put(new Trip(Destination.Mumbai, Destination.Chennai), 1234.5);
	}

	@Override
	public double getTripDistance(Trip trip) {
		double tripDistance = 0;

		if (distanceMap.containsKey(trip)) {
			tripDistance = distanceMap.get(trip);
		} else if (distanceMap.containsKey(trip.reverseTrip())) {
			tripDistance = distanceMap.get(trip.reverseTrip());
		}

		return tripDistance;
	}

	@Override
	public double getTripDistance(List<Trip> trips) {
		double tripDistance = 0;
		for (Trip trip : trips) {
			tripDistance += getTripDistance(trip);
		}
		return tripDistance;
	}

}

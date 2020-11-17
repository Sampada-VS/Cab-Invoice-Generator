package com.blz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<String, ArrayList<Ride>> userRides;

	public RideRepository() {
		this.userRides = new HashMap<>();
	}

	public void addRides(String userId, Ride[] rides) {
		ArrayList<Ride> ridesList = this.userRides.get(userId);
		if (ridesList != null)
			ridesList.addAll(Arrays.asList(rides));
		else {
			ridesList = new ArrayList<>(Arrays.asList(rides));
			this.userRides.put(userId, ridesList);
		}
	}

	public Ride[] getRides(String userId) {
		return this.userRides.get(userId).toArray(new Ride[0]);
	}
}

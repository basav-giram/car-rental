package common.api.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import common.api.VehicleCostCalculator;
import common.data.Money;
import common.data.Vehicle;
import common.data.types.VehicleType;

/**
 * Default implementation of VehicleCharge.
 */
public class VehicleCostCalculatorImpl implements VehicleCostCalculator {

	@Override
	public Money getChargePerKm(Vehicle vehicle, int numberOfPassengers) {
		Money standardCharge = vehicle.getStandardCharge();
		BigDecimal chargePerKm = standardCharge.getAmount();
		
		if(VehicleType.BUS.equals(vehicle.getType())){
			BigDecimal discountedRate = new BigDecimal(0.98);
			discountedRate = discountedRate.setScale(2, RoundingMode.HALF_EVEN);
			chargePerKm = chargePerKm.multiply(BigDecimal.valueOf(0.98), Money.MATH_CONTEXT);
		}
		
		if (vehicle.isDieselVehicle()) {
			chargePerKm = chargePerKm.subtract(BigDecimal.valueOf(1));
		}
		if (vehicle.isAcVehicle()) {
			chargePerKm = chargePerKm.add(BigDecimal.valueOf(2));
		}

		for (int counter = numberOfPassengers; counter > vehicle.getPassengerLimit(); counter--) {
			chargePerKm = chargePerKm.add(BigDecimal.valueOf(1));
		}
		return new Money(standardCharge.getCurrency(), chargePerKm);
	}

}

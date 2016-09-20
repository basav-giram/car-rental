/**
 * 
 */
package common.data;

import common.data.types.VehicleType;

/**
 * Vehicle Class 
 */
public class Vehicle {
	private VehicleType type;
	private Money standardCharge;
	private boolean dieselVehicle;
	private boolean acVehicle;
	private int passengerLimit;
		
	public Vehicle(VehicleType type, Money standardCharge,
			boolean dieselVehicle, boolean acVehicle, int passengerLimit) {
		super();
		this.type = type;
		this.standardCharge = standardCharge;
		this.dieselVehicle = dieselVehicle;
		this.acVehicle = acVehicle;
		this.passengerLimit = passengerLimit;
	}
	
	public VehicleType getType() {
		return type;
	}
	public Money getStandardCharge() {
		return standardCharge;
	}
	public boolean isDieselVehicle() {
		return dieselVehicle;
	}
	public boolean isAcVehicle() {
		return acVehicle;
	}
	public int getPassengerLimit() {
		return passengerLimit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acVehicle ? 1231 : 1237);
		result = prime * result + (dieselVehicle ? 1231 : 1237);
		result = prime * result + passengerLimit;
		result = prime * result
				+ ((standardCharge == null) ? 0 : standardCharge.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (acVehicle != other.acVehicle)
			return false;
		if (dieselVehicle != other.dieselVehicle)
			return false;
		if (passengerLimit != other.passengerLimit)
			return false;
		if (standardCharge == null) {
			if (other.standardCharge != null)
				return false;
		} else if (!standardCharge.equals(other.standardCharge))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", standardCharge=" + standardCharge
				+ ", dieselVehicle=" + dieselVehicle + ", acVehicle="
				+ acVehicle + ", passengerLimit=" + passengerLimit + "]";
	}
	
	
		
}

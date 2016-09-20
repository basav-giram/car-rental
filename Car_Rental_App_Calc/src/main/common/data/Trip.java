package common.data;

import common.data.types.Destination;

/**
 * Class to represent Trip
 */
public class Trip {
	
	Destination start;
	Destination end;
	
	public Trip(Destination start, Destination end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	/**
	 * Method to create reverse trip. 
	 *  
	 * @return reverse Trip
	 */
	public Trip reverseTrip(){
		return new Trip(end, start);
	}

	public Destination getStart() {
		return start;
	}

	public Destination getEnd() {
		return end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Trip other = (Trip) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trip [start=" + start + ", end=" + end + "]";
	}
	
}

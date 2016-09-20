package common.api;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import common.api.impl.VehicleCostCalculatorImpl;
import common.data.Money;
import common.data.Vehicle;
import common.data.types.CurrencyCode;
import common.data.types.VehicleType;

public class VehicleCostCalculatorTest {
	
	VehicleCostCalculator calculator;
	
	@Before
	public void setUp() {
		calculator = new VehicleCostCalculatorImpl();
	}
	
	@Test
	public void testPetrolStandardVehicalCost() {
		Money chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(15)), false, false, 3), 3);
		assertEquals(new Money(CurrencyCode.INR, new BigDecimal(15)), chargePerKM);			
		
		//Extra passengers
		chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(15)), false, false, 3), 5);
		assertEquals(new Money(CurrencyCode.INR, new BigDecimal(17)), chargePerKM);
	}
	
	@Test
	public void testPetrolACVehicalCost() {
		Money chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(15)), false, true, 3), 2);
		assertEquals(new Money(CurrencyCode.INR, new BigDecimal(17)), chargePerKM);
		
		//Extra passengers
		chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(15)), false, true, 3), 5);
		assertEquals(new Money(CurrencyCode.INR, new BigDecimal(19)), chargePerKM);
	}
	
	@Test
	public void testDieselStandardVehicalCost() {
		Money chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(15)), true, false, 3), 3);
		assertEquals(new Money(CurrencyCode.INR, new BigDecimal(14)), chargePerKM);			
		
		//Extra passengers
		chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(15)), true, false, 3), 5);
		assertEquals(new Money(CurrencyCode.INR, new BigDecimal(16)), chargePerKM);
	}
	
	@Test
	public void testDieselACVehicalCost() {
		Money chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(15)), true, true, 3), 2);
		assertEquals(new Money(CurrencyCode.INR, new BigDecimal(16)), chargePerKM);
		
		//Extra passengers
		chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.CAR, 
				new Money(CurrencyCode.INR, new BigDecimal(15)), true, true, 3), 5);
		assertEquals(new Money(CurrencyCode.INR, new BigDecimal(18)), chargePerKM);
	}
	
	@Test
	public void testBusCost() {
		//Petrol Bus
		Money chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.BUS, 
				new Money(CurrencyCode.INR, new BigDecimal(10)), false, false, 3), 3);
		assertEquals(new Money(CurrencyCode.INR, BigDecimal.valueOf(9.8)), chargePerKM);			
		
		//Diesel Bus
		chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.BUS, 
				new Money(CurrencyCode.INR, new BigDecimal(10)), true, false, 3), 3);
		assertEquals(new Money(CurrencyCode.INR, BigDecimal.valueOf(8.8)), chargePerKM);
		
		//AC Bus
		chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.BUS, 
				new Money(CurrencyCode.INR, new BigDecimal(10)), true, true, 3), 3);
		assertEquals(new Money(CurrencyCode.INR, BigDecimal.valueOf(10.8)), chargePerKM);
		
		//Extra passengers
		chargePerKM = calculator.getChargePerKm(new Vehicle(VehicleType.BUS, 
				new Money(CurrencyCode.INR, new BigDecimal(10)), true, true, 3), 5);
		assertEquals(new Money(CurrencyCode.INR, BigDecimal.valueOf(12.8)), chargePerKM);
	}
}

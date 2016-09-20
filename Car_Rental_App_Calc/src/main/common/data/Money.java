package common.data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import common.data.types.CurrencyCode;

/**
 * Class to represent money (currency, amount)
 */
public class Money {
	
	public static MathContext MATH_CONTEXT = new MathContext(2, RoundingMode.HALF_EVEN); 
	
	CurrencyCode currency;
	BigDecimal amount;
	
	public Money(CurrencyCode currency, BigDecimal amout) {
		super();
		this.currency = currency;
		this.amount = amout;
	}

	public CurrencyCode getCurrency() {
		return currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
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
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency != other.currency)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [currency=" + currency + ", amout=" + amount + "]";
	}
	

}

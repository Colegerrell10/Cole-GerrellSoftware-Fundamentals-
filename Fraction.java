package demos.junitdemo;
//package fraction; //package to re-name to before submitting
/**
 * A candidate implementation to store and work with fractions.  Sadly this
 * contains errors.  
 * @author gosnat
 *
 */
public class Fraction  {
	/** Numerator of the fraction */
	private int numerator;
	
	/** Denominator of the fraction */
	private int denominator;
	
	/**
	 * Creates and reduces a fraction
	 * @param numerator starting numerator
	 * @param denominator starting denominator
	 * @throws ArithmeticException if denominator is zero
	 */
	public Fraction(int numerator, int denominator) throws ArithmeticException {
		this.numerator = numerator; //to dodge the reduce() call in setNumerator
		setDenominator(denominator);
		this.reduce();
	}


	/**
	 * @return numerator of the fraction
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * @return denominator of the fraction
	 */
	public int getDenominator() {
		return denominator;
	}
	
	/**
	 * Set requested numerator and reduce resulting fraction
	 * @param numerator new numerator value
	 */
	public void setNumerator(int numerator) {
		this.numerator = numerator;
		reduce();
	}
	
	/**
	 * setRequested denominator and reduce resulting fraction
	 * @param denominator new denominator value
	 * @throws ArithmeticException if requested denominator is zero
	 */
	public void setDenominator(int denominator) throws ArithmeticException{
		if(denominator == 0) throw new ArithmeticException("Denominator can't be zero");
		this.denominator = denominator;
		reduce();
	}

	/**
	 * add other fraction to this one and return resulting sum
	 * @param other the other fraction to add on to this one
	 * @return a new reduced fraction that is the sum of this and other
	 * @throws ArithmeticException if the sum produces an integer overflow in the numerator or denominator
	 */
	public Fraction add(Fraction other) throws ArithmeticException{
		long tempNum1 = this.numerator;
		long tempNum2 = other.getNumerator();
		long tempDen = this.denominator;
		tempNum1 *= other.getDenominator();
		tempNum2 *= this.denominator;
		tempDen *= other.getDenominator();
		if(tempDen > Integer.MAX_VALUE) {
			throw new ArithmeticException("Denominator Overflow");
		}
		if(tempNum1 + tempNum2 > Integer.MAX_VALUE) {
			throw new ArithmeticException("Numerator Overflow");
		}
				
		return new Fraction((int)(tempNum1+tempNum2), (int) tempDen);
	}
	
	/**
	 * Convert this fraction to reduced form
	 */
	private void reduce() {
		//find GCD using Euclidean algorithm
		int a = Math.abs(numerator);
		int b = Math.abs(denominator);
	    while (a != b) { 
	        if (a > b) {
	           a = a - b; 
	        }else {
	           b = b - a; 
	        }
	    }
	    
	    //a is now the GCD
	    numerator /= a;
	    denominator /= a;
	    
	}

}
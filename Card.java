import java.lang.String;

/**
This program uses a checksum operation to determine if a credit card number provided by the user is valid.
@author Brynn Haley
*/
public class Card{
	
	/**
	The user inputted credit card number to be converted to and stored in an array as integers.
	*/
	private String num;
	/**
	Stores the user's inputted string as individual integers.
	*/
	private int[] a = new int[16];
	/** 
	Temporary variable used for assigning values to the array.
	*/
	private int temp =0;
	/**
	A check that determines whether the user's credit card number was declared valid or invalid.
	*/
	private boolean valid = false;
	
	/**
	Constructs a credit card comprised of a 16 digit number.
	@param num The user's inputted credit card number.
	*/
	public Card(String num){
		this.num = num;
	}
	
	/**
	This method populates the array with integers parsed from the user inputted string of numbers.
	@param num The credit card number.
	*/
	public void addNums(String num){
		for(int i=0; i<a.length;i++){
			temp = Character.getNumericValue(num.charAt(i));
			a[i] = temp;
		}
	}
	
	/**
	This method uses a checksum to determine if the credit card number is valid.
	@param a The array of integers contained in the credit card number.
	*/
	public void validate(int[] a){
		int sum = 0;
		for(int i=0;i<a.length-1;i+=2){
			a[i] = a[i]*2; //doubles every other array element
			if(a[i] > 9)
				a[i] = a[i]%10 +1; //adds both digits in the element together, resulting in a single digit element
		}
		for(int i=0; i < a.length; i++){
			sum+= a[i];
		}
		if(sum % 10 == 0)
			valid = true;
		else
			valid = false;
	}
	
	/**
	This method reports the validity status of the card number.
	@returns valid Returns true if the card number is valid, false if it is not.
	*/
	public boolean isValid(){
		return valid;
	}
	
	/** 
	A getter method for use with the GUI, provides the string of numbers inputted by the user.
	@returns num The user's credit card number.
	*/
	public String getNum(){
		return num;
	}
	
	/**
	A getter method for use with the GUI, provides the array of integers.
	@returns a The array of integers included in the credit card number.
	*/
	public int[] getArray(){
		return a;
	}
	
}
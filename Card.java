import java.lang.String;

public class Card{
	
	/* store each digit from a string in an array by using charAt()
	
	*/
	
	private String num;
	private int[] a = new int[16];
	private int temp =0;
	
	public Card(String num){
		this.num = num;
	}
	
	public void addNums(String num){
		for(int i=0; i<a.length;i++){
			temp = Character.getNumericValue(num.charAt(i));
			a[i] = temp;
			System.out.println("array at index " + i + ": " + a[i]);
		}
	}
	
	public void validate(int[] a){
		for(int i=0;i<a.length-1;i+=2){
			a[i] = a[i]*2; //doubles every other array element
			if(a[i] > 9)
				a[i] = a[i]%10 +1; //adds both digits in the element together, resulting in a single digit element
			System.out.println("array at index " + i + ": " + a[i]);
		}
	}
	
	public void printArray(int[] a){
		for(int i=0;i<a.length;i++){
		System.out.println("array at index " + i + ": " + a[i]);
		}
	}
	
	public static void main(String[] args){
		
		Card c = new Card("1234567891234567");
		c.addNums(c.num);
		System.out.println("--------------------------------------");
		c.validate(c.a);
		System.out.println("--------------------------------------");
		c.printArray(c.a);
		}
	}
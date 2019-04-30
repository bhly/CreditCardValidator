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
	
	public void validate(String num){
		for(int i=0; i<a.length;i++){
			temp = Character.getNumericValue(num.charAt(i));
			a[i] = temp;
			System.out.println("array at index " + i + ": " + a[i]);
		}
	}
	
	public static void main(String[] args){
		
		Card c = new Card("1234567891234567");
		c.validate(c.num);
		
		}
	}
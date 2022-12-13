class demo{


	public static void reverseNo(int no){

		int rev =0;
		int n1 =no;
		while(n1>0){
			int temp = n1/10;
			rev = (rev * 10) + rev;
			n1 = n1%10;
		}
		
		System.out.println(rev);
	}
public static void main(String args[]){

System.out.println("HEELO WORLD");
}
}
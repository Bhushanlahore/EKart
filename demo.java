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

//bug no 101 fixing changes
public static void reverseStr(String str){
	String str1 = "";
	int n = str.length();

	for(int i=n-1; i>=0; i--){
		
		str1 = str1 + str.charAt(i);
	}

	System.out.print(str1);
}


public static void main(String args[]){

System.out.println("HEELO WORLD");
}
}
public class J01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int numArray [] = new int [10];
		for (int i=0; i<numArray.length; i++) {
			numArray[i] = (int)(Math.random()*100)+101;
			sum+=numArray[i];
		}
		System.out.println("평균은 "+ (double)(sum/numArray.length));
	}

}

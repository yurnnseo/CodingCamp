import java.util.Arrays;
import java.util.Scanner;

public class J02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하시오 : ");
		
		int index = scn.nextInt();
		
		int [] arr = new int[index]; // arr에 사용자가 입력한 배열의 값이 띄어쓰기를 이용해서 저장
		System.out.print("배열의 입력값을 띄어쓰기를 활용하여 입력하시오 : ");
		
		for (int i=0; i<index; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.print("결과 : " + singleNumber(arr));
	}

	public static int singleNumber(int[] nums) {
		
        // 배열에서 가장 큰 값을 찾음
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i])
                max = nums[i];
        }

        // 발생 횟수를 저장할 배열 생성
        int[] array = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++; // 숫자에 해당하는 인덱스 값 증가
        }

        // 발생 횟수가 1인 숫자를 반환
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                return i;
            }
        }

        // 단 하나의 숫자가 없는 경우 -1 반환
        return -1;
    }
}

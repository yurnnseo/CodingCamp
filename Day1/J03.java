public class J03 {
	
	public static boolean equalInt(int [] a, int [] b) {
		for (int i=0; i<a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1, 2, 3, 4, 5};
		int [] b = {1, 2, 3, 4, 5};
		
		if (equalInt(a, b) == false) {
			System.out.println("두 배열은 다릅니다.");
		}
		else {
			System.out.println("두 배열은 같습니다.");
		}
	}
}

// static을 쓰지 않으면.... 이렇게 

//public class J03 {
//
//    int[] a = {1, 2, 3, 4, 5};
//    int[] b = {1, 2, 3, 4, 5};
//
//    public boolean equalInt(int[] a, int[] b) {
//        if (a.length != b.length) {
//            return false; // 배열 길이가 다르면 false 반환
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] != b[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        J03 obj = new J03(); // 인스턴스 생성
//        if (!obj.equalInt(obj.a, obj.b)) { // 인스턴스를 통해 메서드 호출
//            System.out.println("두 배열은 다릅니다.");
//        } 
//        else {
//            System.out.println("두 배열은 같습니다.");
//        }
//    }
//}


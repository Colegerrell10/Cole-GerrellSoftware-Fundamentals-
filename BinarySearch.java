package demos.junitdemo;

public class BinarySearch {
	/*int[] array;
	int min = 0;
	int max = array.length;*/
	public int calcMiddle(int min, int max, int target) {
		int middle = max - ((max - min)/2);
		if(middle == target) {
			return target;
		}else if(middle < target) {
			return 1;
		}else{
			return -1;
		}
	}
	public static int binarySearch(int[] array, int target) {
		int cond= -1;
		
		//max = array.length;
		//int min= 0;
		// TODO Auto-generated constructor stub
		return cond;
	}

}

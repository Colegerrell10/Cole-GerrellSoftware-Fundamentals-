package demos.junitdemo;

public class BinarySearch {
	int[] array;
	int min = 0;
	int max = array.length;
	public static int binarySearch(int[] array, int min, int max, int target) {
		if(array.length == 0 && array[0] != target){
			return -1;
		}
		int middle = max - ((max - min)/2);
		if(target > middle) {
			return binarySearch(array, middle, max, target);
		}else if(target < middle) {
			return binarySearch(array, min, middle, target); 
		}else {
			return target;
		}
	}
	//delete once we create test cases?
	public static void main (String args[]) {
		int[] sampleArray1 = {1,2,3,4};
		int ex1 = binarySearch(sampleArray1, 1, 4, 3);
		System.out.println(ex1);
	}

}

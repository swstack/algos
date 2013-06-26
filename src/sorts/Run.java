package sorts;
import sorts.MergeSort;

public class Run {

	public static void main(String[] args) {
		int [] searchData = {1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 14, 16, 17, 23};
		MergeSort binarySearch = new BinarySearch();
		binarySearch.setSearchableIntArray(searchData);
		binarySearch.searchData(6);
		binarySearch.printResult();
	}
}

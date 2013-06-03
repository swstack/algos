package searches;


public class BinarySearch implements SearchInterface {
	private int [] searchData;
	private int searchResult;
	
	public BinarySearch() {
	}

	public void setSearchableIntArray(int [] searchData) {
		this.searchData = searchData;
	}

	public void searchData(int searchValue){
		/* Do the Binary Search for the `searchValue` */
		int low = 0;
		int high = this.searchData.length - 1;
		int i = (high + low) / 2;
		while (searchValue != this.searchData[i] && high != low) {
			if (searchValue < this.searchData[i]) {
				high = i -1;
			}
			else {
				low = i + 1;
			}
			i = (high + low) / 2;
		}
		
		// save the solution
		this.searchResult = i;
	}
	
	public void printResult(){
		System.out.println(this.searchResult);
	}
}

"""Insertion sort, in-place (mutable list): O(n^2) worst-case"""

from base import SortABC


class InsertionSort(SortABC):
    def perform(self):
        i = 1
        while i < len(self.unsorted):
            j = i
            while (j > 0) and (self.unsorted[j] < self.unsorted[j - 1]):
                self._swap(j, j - 1)
                j -= 1
            i += 1


if __name__ == "__main__":
    unsorted = [30, 24, 1, 32, 4, 17, 19, 8, 26, 40, 5]
    sort = InsertionSort(unsorted)
    sort.perform()
    sort.display_results()

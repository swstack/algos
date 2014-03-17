"""Bubble sort, in-place (mutable list): O(n^2)"""

from base import SortABC


class BubbleSort(SortABC):
    def perform(self):
        top = len(self.unsorted) - 1

        while top > 0:
            low = 0
            high = 1

            while high <= top:
                if self.unsorted[low] > self.unsorted[high]:
                    self._swap(low, high)

                low += 1
                high += 1

            top -= 1


if __name__ == "__main__":
    unsorted = [30, 24, 1, 32, 4, 17, 19, 8, 26, 40, 5]
    sort = BubbleSort(unsorted)
    sort.perform()
    sort.display_results()

"""Merge sort: O(n log n)"""

from base import SortABC


class MergeSort(SortABC):
    def _merge(self, l1, l2):
        merged = []
        i1 = i2 = 0
        while (i1 <= len(l1) - 1) and (i2 <= len(l2) - 1):
            if l1[i1] > l2[i2]:
                merged.append(l2[i2])
                i2 += 1
            else:
                merged.append(l1[i1])
                i1 += 1

        # we have broken from the while loop but in most cases there could
        # be elements remaining on the end of one of the lists passed in,
        # for now, we don't know which list we reached the end of unfortunately,
        # so by calling the list operation `extend` on the remaining
        # chunks, we know one of them will be an empty list resulting in no change
        # to the merged list
        merged.extend(l1[i1:len(l1)])
        merged.extend(l2[i2:len(l2)])
        return merged

    def _sort(self, array):
        if len(array) == 1:
            return array

        half = len(array) / 2
        left = array[:half]
        right = array[half:]

        sorted_right = self._sort(right)
        sorted_left = self._sort(left)

        return self._merge(sorted_left, sorted_right)

    def perform(self):
        sorted = self._sort(self.unsorted)
        self.unsorted = sorted


if __name__ == "__main__":
    unsorted = [30, 24, 1, 32, 4, 17, 19, 8, 26, 40, 5]
    sort = MergeSort(unsorted)
    sort.perform()
    sort.display_results()

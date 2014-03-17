from base import SortABC


class QuickSort(SortABC):
    def _select_pivot(self, arr):
        index = len(arr) / 2
        return arr[index]

    def _partition(self, arr):
        pivot = self._select_pivot(arr)
        selector1 = 0
        selector2 = len(arr) - 1

        while (arr[selector1] != pivot) and (arr[selector2] != pivot):
            while arr[selector1] < pivot:
                selector1 += 1
            while arr[selector2] > pivot:
                selector2 += 1

            self._swap()

    def perform(self):
        pass


if __name__ == "__main__":
    unsorted = [30, 24, 1, 32, 4, 17, 19, 8, 26, 40, 5]
    sort = QuickSort(unsorted)
    sort.perform()
    sort.display_results()

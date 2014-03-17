"""Binary search algorithm: O(log n)"""
from base import SearchABC, BadInputException


class BinarySearch(SearchABC):
    def _validate_input(self):
        """Make sure the member `self.sorted` exists"""
        if not self.sorted:
            raise BadInputException("Binary search needs sorted input")

    def perform(self):
        self._validate_input()

        iterations = 0

        low = 0
        high = len(self.sorted) - 1

        while (low + 1) < high:
            middle = (low + high) / 2
            if self.sorted[middle] < self.target:
                low = middle
            else:
                high = middle

            iterations += 1

        if self.target == self.sorted[middle]:
            self._complete(True, middle, iterations)


if __name__ == "__main__":
    input = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    search = BinarySearch(6, sorted_input=input)
    search.perform()
    search.display_results()

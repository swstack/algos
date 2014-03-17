"""Linear search Algorithm: O(n)"""

from base import SearchABC


class LinearSearch(SearchABC):
    def perform(self):
        tosearch = self._get_input()

        i = 0
        while i < len(tosearch):
            print "Iter %d: Compare (%d, %d)" % (i, tosearch[i], self.target)
            if tosearch[i] == self.target:
                self._complete(True, i)
                return None
            i += 1


if __name__ == "__main__":
    input = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    search = LinearSearch(6, sorted_input=input)
    search.perform()
    search.display_results()

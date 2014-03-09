import SearchABC


class BinarySearch(SearchABC):
    def perform(self):
        pass


if __name__ == "__main__":
    search = BinarySearch()
    search.perform()
    search.display_results()
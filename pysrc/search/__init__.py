class SearchABC(object):
    """Abstract base class for searching algorithms"""
    def __init__(self, unsorted):
        self._unsorted = unsorted
        self._sorted = []

    def perform(self):
        raise NotImplementedError

    def display_results(self):
        print self._sorted

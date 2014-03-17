class SortABC(object):
    """Generic abstract base class for a Sorting algorithm"""

    def __init__(self, unsorted):
        self.unsorted = unsorted  # becomes sorted in-place
        self.is_sorted = False

    #===========================================================================
    #  Common: Private
    #===========================================================================
    def _swap(self, ione, itwo):
        """Given two indexes, swap them in-place in the list `self.unsorted`"""
        tmp = self.unsorted[itwo]
        self.unsorted[itwo] = self.unsorted[ione]
        self.unsorted[ione] = tmp

    #===========================================================================
    #  Common: Public
    #===========================================================================
    def display_results(self):
        print self.unsorted

    #===========================================================================
    #  Abstract: Need implementation
    #===========================================================================
    def perform(self):
        raise NotImplementedError("Abstract Method")

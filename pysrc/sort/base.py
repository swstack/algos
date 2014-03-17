class SortABC(object):
    """Generic abstract base class for a Sorting algorithm"""

    def __init__(self, unsorted):
        self.unsorted = unsorted  # becomes sorted in-place
        self.is_sorted = False

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

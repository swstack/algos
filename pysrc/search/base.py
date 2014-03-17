import sys


class BadInputException(Exception):
    """Exception raised when instantiating a Search and no input is provided"""


class _Sorted(list):
    """A unique type for a sorted iterable"""


class _UnSorted(list):
    """A unique type for an unsorted iterable"""


class SearchABC(object):
    """Generic abstract base class for a Searching algorithm

    Attempts to handle searching algorithms that take sorted and unsorted
    input in some generic fashion, albeit it's not perfect.
    """

    def __init__(self, target, sorted_input=None, unsorted_input=None):
        if sorted_input:
            self.sorted = _Sorted(sorted_input)
            self.unsorted = None
        elif unsorted_input:
            self.unsorted = _UnSorted(unsorted_input)
            self.sorted = None
        else:
            raise BadInputException("Must include sorted or unsorted input")

        # state before seach is run
        self.target = target

        # state computed during search
        self.found = False
        self.index = None
        self.iterations = None

    #===========================================================================
    #  Common: Internal
    #===========================================================================
    def _get_input(self):
        """This method will return either a new sorted or unsorted list

        We can be sure that either `self.sorted` or `self.unsorted` exist
        because an exception is raised at instantiation time
        """
        if self.sorted:
            return self.sorted[:]
        if self.unsorted:
            return self.unsorted[:]

        print "CRITICAL ERROR: Expected sorted or unsorted input"
        sys.exit(1)

    def _complete(self, found, index, iterations):
        self.found = found
        self.index = index
        self.iterations = iterations

    #===========================================================================
    #  Common: Public
    #===========================================================================
    def display_results(self):
        if self.found:
            print "FOUND: %s at index %s in %s iterations" % (self.target,
                                                              self.index,
                                                              self.iterations)
        else:
            print "ERROR: NOT FOUND"

    #===========================================================================
    #  Abstract: Need implementation
    #===========================================================================
    def perform(self):
        raise NotImplementedError("Abstract Method")

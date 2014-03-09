def partition(a, left, right):  # left and right are the start and end indexes of the subarray
    i = left + 1
    pivot = a[left]  # choose first element in subarray as pivot
     
    for j in range(left + 1, right + 1):
        if a[j] < pivot:
            a[j], a[i] = a[i], a[j]
            i += 1
     
    pos = i - 1
    a[left], a[pos] = a[pos], a[left]
     
    return pos  # new pivot position. Used to divide the next left and right side of the array.


def quick_sort(a, left, right):
    pivot_pos = partition(a, left, right )
    quick_sort(a, left, pivot_pos - 1)
    quick_sort(a, pivot_pos + 1, right)


if __name__ == "__main__":
    unsorted = [765, 56, 8, 99, 3, 4, 2945, 56, 2, 20, 60, 1, 500]
    quick_sort(unsorted, 0, len(unsorted) - 1)
    print unsorted

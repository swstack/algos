"""Top down merge sort algorithm"""

def merge(arr1, arr2):
    merged = []
    index_arr1 = 0
    index_arr2 = 0

    while True:
        val1 = arr1[index_arr1]
        val2 = arr2[index_arr2]

        if val1 >= val2:
            merged.append(val2)
            index_arr2 += 1
            if index_arr2 == len(arr2):
                # This array is finished, now we just append the rest of the other
                # array on the end
                merged.extend(arr1[index_arr1:])
                break
        else:
            merged.append(val1)
            index_arr1 += 1
            if index_arr1 == len(arr1):
                # This array is finished, now we just append the rest of the other
                # array on the end
                merged.extend(arr2[index_arr2:])
                break
    return merged


def sort(array):
    alen = len(array)
    if alen <= 1:
        return array

    left = array[:alen / 2]
    right = array[alen / 2:]

    left = sort(left)
    right = sort(right)

    merged = merge(left, right)
    return merged


if __name__ == "__main__":
    unsorted = [3, 2, 5, 1, 1, 6]
    sorted = sort(unsorted)
    print sorted
    
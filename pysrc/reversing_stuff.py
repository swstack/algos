def reverse_list(list):
    reversed_list = []
    index = len(list) - 1
    while index >= 0:
        reversed_list.append(list[index])
        index -= 1
    return reversed_list

def reverse_bits_from_byte(byte):
    byte = ord(byte)
    bit0 = 1 if byte & 1 else 0
    bit1 = 1 if byte & 2 else 0
    bit2 = 1 if byte & 4 else 0
    bit3 = 1 if byte & 8 else 0
    bit4 = 1 if byte & 16 else 0
    bit5 = 1 if byte & 32 else 0
    bit6 = 1 if byte & 64 else 0
    bit7 = 1 if byte & 128 else 0
    return [bit0, bit1, bit2, bit3, bit4, bit5, bit6, bit7]


if __name__ == "__main__":
    my_list = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    reversed_list = reverse_list(my_list)

    my_byte = "\x05"
    reversed_bits = reverse_bits_from_byte(my_byte)

    print "Original List: %r" % my_list
    print "Reversed List: %r" % reversed_list

    print "Original byte: %d" % ord(my_byte)
    print "Reversed bits: %r" % reversed_bits

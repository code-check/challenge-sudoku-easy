def is_valid(sudoku):
    #BEGIN_CHALLENGE
    chars = list(sudoku)
    data = [[0 for x in range(9)] for x in range(9)]
    sum = 0
    for x in range(9):
        for y in range(9):
            data[x][y] = ord(chars[x + (y * 9)]) - 0x30
            sum += data[x][y]
    # check sum
    if sum != 405:
        return False

    # check cells
    for val in range(1, 10):
        for cell in range(9):
            count = 0
            sx = cell % 3
            sy = cell - sx
            sx *= 3

            for x in range(3):
                for y in range(3):
                    if data[x + sx][y + sy] == val:
                        count += 1
                        if count > 1:
                            return False

    # check columns
    for val in range(1, 10):
        for x in range(9):
            count = 0
            for y in range(9):
                if data[x][y] == val:
                    count += 1
                    if count > 1:
                        return False

    # check rows
    for val in range(1, 10):
        for y in range(9):
            count = 0
            for x in range(9):
                if data[x][y] == val:
                    count += 1
                    if count > 1:
                        return False

    #END_CHALLENGE
    return True
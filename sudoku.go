package sudoku

func IsValid(sudoku string) bool {
//BEGIN_CHALLENGE
	// Appereantly Go is quite strict about types and does not allow a int8 to be added an int
	var data [9][9]int; 
	sum := 0

	// Create array and compute field sum
	for x := 0; x < 9; x++ {
		for y := 0; y < 9; y++ {
			data[x][y] = int(sudoku[x * 9 + y] - 0x30)
			sum += data[x][y]
		}
	}

	// Check field sum
	if sum != 405 {
		return false
	}

	// Check cells
	for val := 1; val <= 9; val++ {
		for cell := 0; cell < 9; cell++ {
			count := 0
			sx := cell % 3
			sy := cell - sx
			sx *= 3

			for x := 0; x < 3; x++ {
				for y := 0; y < 3; y++ {
					if data[x + sx][y + sy] == val {
						count++
						if count > 1 {
							return false
						}
					}
				}
			}
		}
	}

	// Check rows
	for val := 1; val <= 9; val++ {
		for y := 0; y < 9; y++ {
			count := 0
			for x := 0; x < 9; x++ {
				if data[x][y] == val {
					count++
					if count > 1 {
						return false
					}
				}
			}
		}
	}

	// Check columns
	for val := 1; val <= 9; val++ {
		for x := 0; x < 9; x++ {
			count := 0
			for y := 0; y < 9; y++ {
				if data[x][y] == val {
					count++
					if count > 1 {
						return false
					}
				}
			}
		}
	}

//END_CHALLENGE
	return true
}
object Solver {
  def validateSudoku(sudoku: String): Boolean = {
    //BEGIN_CHALLENGE
    val parsed: Array[Array[Byte]] =
      sudoku
        .toCharArray
        .map(_.toByte - 0x30)
        .map(_.toByte)
        .grouped(9)
        .toArray

    // Check the cells
    for {
      v <- 1 to 9
      c <- 0 until 9
    } {
      var count = 0
      val sy = c - (c % 3)
      val sx = 3 * (c % 3)
      for {
        x <- 0 until 3
        y <- 0 until 3
      } {
        if (parsed(x + sx)(y + sy) == v) {
          count += 1
          if (count > 1)
            return false
        }
      }
    }

    // Check the columns
    for {
      v <- 1 to 9
      x <- 0 until 9
    } {
      var count = 0
      for (y <- 0 until 9)
        if (parsed(x)(y) == v)
        {
          count += 1
          if (count > 1)
            return false
        }
    }

    // Check the rows
    for {
      v <- 1 to 9
      y <- 0 until 9
    } {
      var count = 0
      for (x <- 0 until 9)
        if (parsed(x)(y) == v)
        {
          count += 1
          if (count > 1)
            return false
        }
    }

    true
    //END_CHALLENGE
  }
}

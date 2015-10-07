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

    // Check the sudoku for 0's
    val checkCount: Boolean =
      parsed.flatten.map(_.toInt).sum == 9 * ((9 * (9 + 1)) / 2)

    // Check the cells
    val checkCells: Boolean =
      !(for {
        v <- 1 to 9
        c <- 0 until 9
      } yield {
          val y = c - (c % 3)
          val x = 3 * (c % 3)
          (for (ix <- 0 until 3; iy <- 0 until 3) yield (ix, iy))
            .map { case (ix, iy) => (ix + (x - (x % 3)), iy + (y - (y % 3))) }
            .count { case (ix, iy) => parsed(ix)(iy) == v }
        }).exists(_ >= 2)

    // Check the columns
    val checkColumns: Boolean =
      !(for {
        v <- 1 to 9
        x <- 0 until 9
      } yield (0 until 9).count(parsed(x)(_) == v)
        ).exists(_ >= 2)

    // Check the rows
    val checkRows: Boolean =
      !(for {
        v <- 1 to 9
        y <- 0 until 9
      } yield (0 until 9).count(parsed(_)(y) == v)
        ).exists(_ >= 2)

    checkCount & checkCells & checkColumns & checkRows
    //END_CHALLENGE
  }
}

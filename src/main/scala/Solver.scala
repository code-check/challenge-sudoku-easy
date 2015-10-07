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
    def checkCells: Boolean =
      (for {
        v <- 1 to 9
        c <- 0 until 9
      } yield {
          var count = 0
          val sy = c - (c % 3)
          val sx = 3 * (c % 3)
          for {
            x <- 0 until 3
            y <- 0 until 3
          } {
            if (parsed(x + sx)(y + sy) == v)
              count += 1
          }

          count <= 1
        }).foldLeft(true)((l, r) => l & r)

    // Check the columns
    def checkColumns: Boolean =
      (for {
        v <- 1 to 9
        x <- 0 until 9
      } yield {
          var count = 0
          for (y <- 0 until 9)
            if (parsed(x)(y) == v)
              count += 1

          count <= 1
        }).foldLeft(true)((l, r) => l & r)

    // Check the rows
    def checkRows: Boolean =
      (for {
        v <- 1 to 9
        y <- 0 until 9
      } yield {
          var count = 0
          for (x <- 0 until 9)
            if (parsed(x)(y) == v)
              count += 1

          count <= 1
        }).foldLeft(true)((l, r) => l & r)

    checkCells & checkColumns & checkRows
    //END_CHALLENGE
  }
}

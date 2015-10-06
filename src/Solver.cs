using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SudokuChallengeEasy.src
{
    public static class Solver
    {
        public static bool IsValidSolution(string sudoku)
        {
            //BEGIN_CHALLENGE
            // Basic sum check
            const int sudokusum = 9 * ((9 * (9 + 1)) / 2);
            if (sudokusum != sudoku.Sum(x => x - 0x30))
                return false;

            // Parse the sudoku to an array
            var parsed = new byte[9, 9];
            for (int x = 0; x < 9; x++)
                for (int y = 0; y < 9; y++)
                    parsed[y, x] = (byte)(sudoku[x + (y * 9)] - 0x30);

            // Check the cells
            for (int val = 1; val <= 9; val++)
            {
                for (int cell = 0; cell < 9; cell++)
                {
                    int count = 0;
                    int startx = cell % 3;
                    int starty = cell - (cell % 3);
                    startx *= 3;

                    for (int x = 0; x < 3; x++)
                        for (int y = 0; y < 3; y++)
                            if (parsed[x + startx, y + starty] == val)
                                if (count++ > 0)
                                    return false;
                }
            }

            // Check the rows
            for (int val = 1; val <= 9; val++)
            {
                for (int y = 0; y < 9; y++)
                {
                    int count = 0;
                    for (int x = 0; x < 9; x++)
                    {
                        if (parsed[x, y] == val)
                            if (count++ > 0)
                                return false;
                    }
                }
            }

            // Check the columns
            for (int val = 1; val <= 9; val++)
            {
                for (int x = 0; x < 9; x++)
                {
                    int count = 0;
                    for (int y = 0; y < 9; y++)
                    {
                        if (parsed[x, y] == val)
                            if (count++ > 0)
                                return false;
                    }
                }
            }

            return true;
            //END_CHALLENGE
        }
    }
}

using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SudokuChallengeEasy.src
{
    [TestFixture]
    public class Tests
    {
        /*
483921657
967345821
251876493
548132976
729564138
136798245
372689514
814253769
695417382
         * 
954213687
617548923
832796541
763851294
128974365
549362178
281637459
475129836
396485712
         */
        private string[] Sudokus = { 
                                       "782614359439825176651937428293471864568392715147568293326749581975183662814256937",
                                       "782614359439825176651937428293471864568392715147568293326749581975183642814256937",
                                       "782614359439825176651937428293471865568392714147568293326749581975183642814256937",
                                       "483921654967345821251876493548132976729564138136798245372689514814253769695417382",
                                       "954213687617548923832796541763851294128974365549362178281637459475129836396485712",
                                       "954213687617548923832796541763851294128974365549362178281637549475129836396485712"
                                   };
        private bool[] Results = {
                                     false,
                                     false,
                                     true,
                                     false,
                                     true,
                                     false
                                 };

        [Test]
        public void Test()
        {
            int i = 0;
            foreach (string sudoku in Sudokus)
            {
                Console.WriteLine(i);
                Assert.AreEqual(Results[i++], Solver.IsValidSolution(sudoku));
            }
        }
    }
}

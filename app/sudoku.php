<?php

function isValid($sudoku) {
    //BEGIN_CHALLENGE
    // Check sum
    $sum = 0;
    for ($i = 0; $i < strlen($sudoku); $i++) {
        $sum += intval($sudoku[$i]);
    }
    if ($sum != 405)
        return false;

    // Create data array
    $data = array();
    for ($i = 0; $i < 9; $i++)
    {
        $data[] = array();
        for ($j = 0; $j < 9; $j++)
        {
            $data[$i][] = intval($sudoku[$i * 9 + $j]);
        }
    }

    // Check cells
    for ($val = 1; $val <= 9; $val++) {
        for ($cell = 0; $cell < 9; $cell++) {
            $count = 0;
            $startx = $cell % 3;
            $starty = $cell - $startx;
            $startx *= 3;

            for ($x = 0; $x < 3; $x++) {
                for ($y = 0; $y < 3; $y++) {
                    if ($data[$x + $startx][$y + $starty] == $val) {
                        if ($count++ > 0) return false;
                    }
                }
            }
        }
    }

    // Check rows
    for ($val = 1; $val <= 9; $val++)
    {
        for ($y = 0; $y < 9; $y++)
        {
            $count = 0;
            for ($x = 0; $x < 9; $x++)
            {
                if ($data[$x][$y] == $val)
                    if ($count++ > 0) return false;
            }
        }
    }

    // Check columns
    for ($val = 1; $val <= 9; $val++)
    {
        for ($x = 0; $x < 9; $x++)
        {
            $count = 0;
            for ($y = 0; $y < 9; $y++)
            {
                if ($data[$x][$y] == $val)
                    if ($count++ > 0) return false;
            }
        }
    }
    //END_CHALLENGE
    return true;
}
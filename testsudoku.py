from nose.tools import assert_equal
from sudoku import is_valid

def test_is_valid():
    assert_equal(False, is_valid("782614359439825176651937428293471864568392715147568293326749581975183662814256937"))
    assert_equal(False, is_valid("782614359439825176651937428293471864568392715147568293326749581975183642814256937"))
    assert_equal(True, is_valid("782614359439825176651937428293471865568392714147568293326749581975183642814256937"))
    assert_equal(False, is_valid("483921654967345821251876493548132976729564138136798245372689514814253769695417382"))
    assert_equal(True, is_valid("954213687617548923832796541763851294128974365549362178281637459475129836396485712"))
    assert_equal(False, is_valid("954213687617548923832796541763851294128974365549362178281637549475129836396485712"))
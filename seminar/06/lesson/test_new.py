from unittest.mock import Mock

import pytest
from Tasks import Tasks

def test_find_average():
    assert Tasks.find_average([1, 4, 7]) == 4

def test_find_average_type_error():
    with pytest.raises(TypeError):
        Tasks.find_average("6")

def test_transfer_money():
    person = Tasks.Person(1000)
    bank = Tasks.Bank()
    person.transfer_money(1000, bank)

    assert person.balance == 0
    assert bank.balance == 1000

def test_transfer_money_value_error():
    person = Tasks.Person(1000)
    bank = Tasks.Bank()

    with pytest.raises(ValueError):
        person.transfer_money(2000, bank)

def test_transfer_money_mock():
    person = Tasks.Person(1000)
    bank_mock = Mock()

    person.transfer_money(500, bank_mock)
    bank_mock.receive_money.assert_called_with(500)

def test_divide_zero_division_error():
    with pytest.raises(ZeroDivisionError):
        Tasks.divide(10, 0)

@pytest.mark.parametrize("a, b, expected",[
    (10, 0, 0),
    (2, 4, 8),
    (-1, 5, -5),
    (-2, -2, 4)
])
def test_multiply(a, b, expected):
    assert Tasks.multiply(a, b) == expected

@pytest.mark.parametrize("string, length",[
    ("hello", 5),
    ("", 0),
    (" ", 1)
])
def test_len(string, length):
    assert len(string) == length

@pytest.mark.parametrize("number, expected",[
    (2, True),
    (7, True),
    (11, True),
    (17, True),
    (31, True),
    (8, False)
])
def test_is_prime(number, expected):
    assert Tasks.is_prime(number) == expected

package com.example.hw2_calculatorapp.CalculatorMath

interface AbstractStringIterator {
    operator fun hasNext(): Boolean
    operator fun next(): String?
}
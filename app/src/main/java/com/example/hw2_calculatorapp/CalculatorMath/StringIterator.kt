package com.example.hw2_calculatorapp.CalculatorMath

class StringIterator(string: String) : AbstractStringIterator {
    private val string: String?
    private var currentIndex: Int

    init {
        this.string = string.replace(" ", "")
        currentIndex = 0
    }

    override fun hasNext(): Boolean {
        return string != null &&
                !string.isEmpty() && currentIndex < string.length
    }

    override fun next(): String? {
        val operand = StringBuilder()
        var element = string!![currentIndex]
        while (Character.isDigit(element) || element == '.' || currentIndex == 0 && element == '-' ||
            currentIndex > 0 && string[currentIndex - 1] == '(' && element == '-'
        ) {
            operand.append(element)
            currentIndex++
            if (currentIndex == string.length) return operand.toString()
            element = string[currentIndex]
        }
        if (operand.length != 0) return operand.toString()
        currentIndex++
        return Character.toString(element)
    }
}
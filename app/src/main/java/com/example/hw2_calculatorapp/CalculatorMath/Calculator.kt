package com.example.hw2_calculatorapp.CalculatorMath

import java.util.*

class Calculator(
    private val priorities: AbstractOperatorsPriorities,
    private val iterator: AbstractStringIterator
) {
    private val numbers: Stack<Double?>
    private val operators: Stack<String?>

    init {
        numbers = Stack()
        operators = Stack()
    }

    @get:Throws(NullPointerException::class, EmptyStackException::class)
    val result: Double?
        get() {
            while (iterator.hasNext()) {
                val element = iterator.next()
                try {
                    val number = element!!.toDouble()
                    numbers.push(number)
                } catch (e: NumberFormatException) {
                    if (element == "(") {
                        operators.push(element)
                    } else if (element == ")") {
                        while (operators.peek() != "(") calculate()
                        operators.pop()
                    } else {
                        if (operators.empty()) {
                            operators.push(element)
                        } else {
                            val priority = priorities.getPriority(element)
                            while (!operators.empty() && operators.peek() != "(" && operators.peek() != ")" && priority!! <= priorities.getPriority(
                                    operators.peek()
                                )!!
                            ) {
                                calculate()
                            }
                            operators.push(element)
                        }
                    }
                }
            }
            while (!operators.empty()) {
                calculate()
            }
            return numbers.pop()
        }

    @Throws(EmptyStackException::class)
    private fun calculate() {
        val operator = operators.pop()
        val n2 = numbers.pop()
        val n1 = numbers.pop()
        var result: Double? = null
        when (operator) {
            "+" -> result = n1!! + n2!!
            "-" -> result = n1!! - n2!!
            "*" -> result = n1!! * n2!!
            "/" -> result = n1!! / n2!!
        }
        numbers.push(result)
    }

}
package com.example.hw2_calculatorapp.CalculatorMath

import java.util.*

class CalcMain {
    fun doCalculation(str: String): String {
        val expression: String = str
        if (expression.isEmpty()) {
            return "Ввод пуст"
        }
        val priorities: AbstractOperatorsPriorities = OperatorsPriorities()
        priorities.addOperator("+", 1)
        priorities.addOperator("-", 1)
        priorities.addOperator("*", 2)
        priorities.addOperator("/", 2)
        val iterator: AbstractStringIterator = StringIterator(expression)
        val calculator = Calculator(priorities, iterator)
        return try {
            val result: Double? = calculator.result
            result.toString()
        } catch (e: EmptyStackException){
            "Ошибка ввода"
        }
    }
}
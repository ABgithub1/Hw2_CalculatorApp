package com.example.hw2_calculatorapp.CalculatorMath

interface AbstractOperatorsPriorities {

    fun getPriority(operator: String?): Int?

    fun addOperator(operator: String?, priority: Int)

    fun deleteOperator(operator: String?)
}
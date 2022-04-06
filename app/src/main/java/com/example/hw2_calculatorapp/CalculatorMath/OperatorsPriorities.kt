package com.example.hw2_calculatorapp.CalculatorMath

class OperatorsPriorities : AbstractOperatorsPriorities {

    private var map: MutableMap<String?, Int>

    constructor(map: HashMap<String?, Int>) {
        this.map = map
    }

    constructor() {
        map = HashMap()
    }

    override fun getPriority(operator: String?): Int? {
        return map[operator]
    }

    override fun addOperator(operator: String?, priority: Int) {
        map[operator] = priority
    }

    override fun deleteOperator(operator: String?) {
        map.remove(operator)
    }
}
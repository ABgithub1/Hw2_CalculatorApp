package com.example.hw2_calculatorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw2_calculatorapp.CalculatorMath.CalcMain
import com.example.hw2_calculatorapp.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = requireNotNull(_binding) {"View was destroyed"}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCalculatorBinding.inflate(inflater,container,false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            fun setTextFields(str: String) {
                mathOp.append(str)
            }
            buttonAllClean.setOnClickListener {
                mathOp.text = ""
                mathRes.text = ""
            }
            buttonBracketOpen.setOnClickListener { setTextFields("(") }
            buttonBracketClose.setOnClickListener { setTextFields(")") }
            buttonDivide.setOnClickListener { setTextFields("/") }
            buttonMultiply.setOnClickListener { setTextFields("*") }
            buttonMinus.setOnClickListener { setTextFields("-") }
            buttonPlus.setOnClickListener { setTextFields("+") }
            buttonDot.setOnClickListener { setTextFields(".") }

            buttonBack.setOnClickListener {
                val str = mathOp.text.toString()
                if (str.isNotEmpty()) {
                    mathOp.text = str.substring(0, str.length - 1)
                }
                mathRes.text = ""
            }

            buttonZero.setOnClickListener { setTextFields("0") }
            button1.setOnClickListener { setTextFields("1") }
            button2.setOnClickListener { setTextFields("2") }
            button3.setOnClickListener { setTextFields("3") }
            button4.setOnClickListener { setTextFields("4") }
            button5.setOnClickListener { setTextFields("5") }
            button6.setOnClickListener { setTextFields("6") }
            button7.setOnClickListener { setTextFields("7") }
            button8.setOnClickListener { setTextFields("8") }
            button9.setOnClickListener { setTextFields("9") }

            buttonEquals.setOnClickListener {
                val calculate = CalcMain()
                mathRes.text = calculate.doCalculation(mathOp.text.toString())

            }
            lastOpButton.setOnClickListener {
                pushFragment()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
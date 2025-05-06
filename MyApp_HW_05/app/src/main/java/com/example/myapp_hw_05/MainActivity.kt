package com.example.myapp_hw_05

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp_hw_05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var textView: TextView

    private var currentInput = ""
    private var lastNumber = 0.0
    private var currentOperator: String? = null
    private var isNewOperation = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6,
            binding.btn7, binding.btn8, binding.btn9
        )

        numberButtons.forEach { button->
            button.setOnClickListener {
                numberClicked(button.text.toString())
            }
        }
        binding.btnPlus.setOnClickListener { operatorClicked("+") }
        binding.btnMinus.setOnClickListener { operatorClicked("-") }
        binding.btnMultiply.setOnClickListener { operatorClicked("*") }
        binding.btnDivide.setOnClickListener { operatorClicked("/") }

        // Diğerleri
        binding.btnEquals.setOnClickListener { calculateResult() }
        binding.btnClear.setOnClickListener { clearAll() }
        binding.btnDot.setOnClickListener { dotClicked() }
        binding.btnPlusMinus.setOnClickListener { toggleSign() }
        binding.btnPercent.setOnClickListener { applyPercent() }
    }

    private fun numberClicked(digit: String) {
        if (isNewOperation) {
            currentInput = ""
            isNewOperation = false
        }
        currentInput += digit
        textView.text = currentInput
    }

    private fun operatorClicked(op: String) {
        lastNumber = currentInput.toDoubleOrNull() ?: 0.0
        currentOperator = op
        isNewOperation = true
    }

    private fun calculateResult() {
        val secondNumber = currentInput.toDoubleOrNull() ?: return
        val result = when (currentOperator) {
            "+" -> lastNumber + secondNumber
            "-" -> lastNumber - secondNumber
            "*" -> lastNumber * secondNumber
            "/" -> if (secondNumber != 0.0) lastNumber / secondNumber else "Error"
            else -> return
        }
        textView.text = result.toString()
        currentInput = result.toString()
        isNewOperation = true
    }

    private fun clearAll() {
        currentInput = ""
        lastNumber = 0.0
        currentOperator = null
        textView.text = "0"
        isNewOperation = true
    }

    private fun dotClicked() {
        if (!currentInput.contains(".")) {
            currentInput += if (currentInput.isEmpty()) "0." else "."
            textView.text = currentInput
        }
    }

    private fun toggleSign() {
        currentInput = if (currentInput.startsWith("-")) {
            currentInput.removePrefix("-")
        } else {
            "-$currentInput"
        }
        textView.text = currentInput
    }

    private fun applyPercent() {
        val number = currentInput.toDoubleOrNull() ?: return
        currentInput = (number / 100).toString()
        textView.text = currentInput
    }
}
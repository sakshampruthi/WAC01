package com.wac01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    var pendingOperation: String = "="
    var operand1: Double? = null
    var operand2: Double? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener {
            //onclicklistener for the buttons
            val b = it as Button
            if (newnum.text.isEmpty())
                newnum.setText(b.text)
            else
                newnum.append(b.text)
        }

        val oplistener = View.OnClickListener {
            //listener for operations
            val b = it as Button
            val op = b.text.toString()
            operation.text = op
            try {
                val value = newnum.text.toString() //gets the value of the number in newnum
                performOperation(value.toDouble(),op)
            } catch (e:NumberFormatException){
                newnum.setText("")
            }
            pendingOperation = op
        }

        button0Num.setOnClickListener(listener)
        button1Num.setOnClickListener(listener)
        button2Num.setOnClickListener(listener)
        button3Num.setOnClickListener(listener)
        button4Num.setOnClickListener(listener)
        button5Num.setOnClickListener(listener)
        button6Num.setOnClickListener(listener)
        button7Num.setOnClickListener(listener)
        button8Num.setOnClickListener(listener)
        button9Num.setOnClickListener(listener)

        buttonEquals.setOnClickListener(oplistener)
        buttonPlus.setOnClickListener(oplistener)
        buttonMinus.setOnClickListener(oplistener)
        buttonMultiply.setOnClickListener(oplistener)
        buttonDivide.setOnClickListener(oplistener)
    }

    fun performOperation(value: Double, op: String) {
        var error = false
        if (null == operand1) {
            operand1 = value
        } else {
            operand2 = value
            if (pendingOperation == "=") {
                pendingOperation = op
            }
            when (pendingOperation) {
                "=" -> operand1 = operand2
                "/" -> if (operand2 == 0.0) {
                    error = true
                } else {
                    operand1 = operand1!!/ operand2!!
                }
                "*" -> operand1 = operand1!! * operand2!!
                "-" -> operand1 = operand1!! - operand2!!
                "+" -> operand1 = operand1!! + operand2!!
            }
        }
        if (!error) {
            if (operand1!! % 1 == 0.0) {
                result!!.setText(String.format("%.0f", operand1))
            } else result!!.setText(String.format("%.4f", operand1))
        } else {
            result!!.setText("Error")
            operand1 = 0.0
        }
        newnum!!.setText("")
    }
}


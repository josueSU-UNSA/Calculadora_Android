package com.crunchify.tutorials.crunchifycalculator

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var button0: Button? = null
    var button1: Button? = null
    var button2: Button? = null
    var button3: Button? = null
    var button4: Button? = null
    var button5: Button? = null
    var button6: Button? = null
    var button7: Button? = null
    var button8: Button? = null
    var button9: Button? = null
    var buttonAdd: Button? = null
    var buttonSub: Button? = null
    var buttonDivision: Button? = null
    var buttonMul: Button? = null
    var button10: Button? = null
    var buttonC: Button? = null
    var buttonEqual: Button? = null
    var crunchifyEditText: EditText? = null
    var mValueOne = 0f
    var mValueTwo = 0f
    var crunchifyAddition = false
    var mSubtract = false
    var crunchifyMultiplication = false
    var crunchifyDivision = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button0 = findViewById<View>(R.id.button0) as Button
        button1 = findViewById<View>(R.id.button1) as Button
        button2 = findViewById<View>(R.id.button2) as Button
        button3 = findViewById<View>(R.id.button3) as Button
        button4 = findViewById<View>(R.id.button4) as Button
        button5 = findViewById<View>(R.id.button5) as Button
        button6 = findViewById<View>(R.id.button6) as Button
        button7 = findViewById<View>(R.id.button7) as Button
        button8 = findViewById<View>(R.id.button8) as Button
        button9 = findViewById<View>(R.id.button9) as Button
        button10 = findViewById<View>(R.id.button10) as Button
        buttonAdd = findViewById<View>(R.id.buttonadd) as Button
        buttonSub = findViewById<View>(R.id.buttonsub) as Button
        buttonMul = findViewById<View>(R.id.buttonmul) as Button
        buttonDivision = findViewById<View>(R.id.buttondiv) as Button
        buttonC = findViewById<View>(R.id.buttonC) as Button
        buttonEqual = findViewById<View>(R.id.buttoneql) as Button
        crunchifyEditText = findViewById<View>(R.id.edt1) as EditText
        button1!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "1") }
        button2!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "2") }
        button3!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "3") }
        button4!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "4") }
        button5!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "5") }
        button6!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "6") }
        button7!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "7") }
        button8!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "8") }
        button9!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "9") }
        button0!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + "0") }
        buttonAdd!!.setOnClickListener {
            if (crunchifyEditText == null) {
                crunchifyEditText!!.setText("")
            } else {
                mValueOne = (crunchifyEditText!!.text.toString() + "").toFloat()
                crunchifyAddition = true
                crunchifyEditText.setText(null)
            }
        }
        buttonSub!!.setOnClickListener {
            mValueOne = (crunchifyEditText!!.text.toString() + "").toFloat()
            mSubtract = true
            crunchifyEditText.setText(null)
        }
        buttonMul!!.setOnClickListener {
            mValueOne = (crunchifyEditText!!.text.toString() + "").toFloat()
            crunchifyMultiplication = true
            crunchifyEditText.setText(null)
        }
        buttonDivision!!.setOnClickListener {
            mValueOne = (crunchifyEditText!!.text.toString() + "").toFloat()
            crunchifyDivision = true
            crunchifyEditText.setText(null)
        }
        buttonEqual!!.setOnClickListener {
            mValueTwo = (crunchifyEditText!!.text.toString() + "").toFloat()
            if (crunchifyAddition == true) {
                crunchifyEditText.setText(mValueOne + mValueTwo + "")
                crunchifyAddition = false
            }
            if (mSubtract == true) {
                crunchifyEditText.setText(mValueOne - mValueTwo.toString() + "")
                mSubtract = false
            }
            if (crunchifyMultiplication == true) {
                crunchifyEditText.setText(mValueOne * mValueTwo.toString() + "")
                crunchifyMultiplication = false
            }
            if (crunchifyDivision == true) {
                crunchifyEditText.setText(mValueOne / mValueTwo.toString() + "")
                crunchifyDivision = false
            }
        }
        buttonC!!.setOnClickListener { crunchifyEditText!!.setText("") }
        button10!!.setOnClickListener { crunchifyEditText!!.setText(crunchifyEditText!!.text.toString() + ".") }
    }
}
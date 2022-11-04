package com.java1001_midterm_a00262875

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

//Creating Class Main Activity
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // Array of Conversion for item spinner
    var items = arrayOf(
        "miles to km",
        "km to miles",
        "c to f",
        "f to c",
        "c to k",
        "f to k",
        "in to cm",
        "lb to kg",
        "kg to lb",
        "oz to gram",
        "gram to oz",
        "cups to liter",
        "liter to cups",
        "cm to in"
    )
    var currentConversion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val converterSpinner = findViewById<View>(R.id.converterSpinner) as Spinner
        val inputText = findViewById<View>(R.id.inputText) as EditText
        val outputText = findViewById<View>(R.id.outputText) as EditText
        val convertButton = findViewById<View>(R.id.convertButton) as Button
        converterSpinner.onItemSelectedListener = this
        val adapter =
            ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        converterSpinner.adapter = adapter
        converterSpinner.onItemSelectedListener = this


        //On Button Click call Function

        convertButton.setOnClickListener {
            if (inputText.text.toString().isEmpty()) {
                outputText.setText("")
            } else if (currentConversion == "km to miles") {
                outputText.setText((inputText.text.toString().toDouble() * 0.62).toString())
            } else if (currentConversion == "miles to km") {
                outputText.setText((inputText.text.toString().toDouble() * 1.60934).toString())
            } else if (currentConversion == "c to f") {
                val tempValue = inputText.text.toString().toDouble()
                outputText.setText((tempValue * 1.8 + 32).toString())
            } else if (currentConversion == "f to c") {
                val tempValue = inputText.text.toString().toDouble()
                outputText.setText(((tempValue - 32) * 5 / 9).toString())
            } else if (currentConversion == "c to k") {
                val tempValue = inputText.text.toString().toDouble()
                outputText.setText((tempValue + 273.15).toString())
            } else if (currentConversion == "f to k") {
                val tempValue = inputText.text.toString().toDouble()
                outputText.setText(((tempValue - 32) * 5 / 9 + 273.15).toString())
            } else if (currentConversion == "kg to lb") {
                outputText.setText((inputText.text.toString().toDouble() * 2.2).toString())
            } else if (currentConversion == "lb to kg") {
                outputText.setText((inputText.text.toString().toDouble() * 0.45).toString())
            } else if (currentConversion == "gram to oz") {
                outputText.setText((inputText.text.toString().toDouble() * 0.04).toString())
            } else if (currentConversion == "oz to gram") {
                outputText.setText((inputText.text.toString().toDouble() * 28.35).toString())
            } else if (currentConversion == "liter to cups") {
                outputText.setText((inputText.text.toString().toDouble() * 4.17).toString())
            } else if (currentConversion == "cups to liter") {
                outputText.setText((inputText.text.toString().toDouble() * 0.24).toString())
            } else if (currentConversion == "in to cm") {
                outputText.setText((inputText.text.toString().toDouble() * 2.54).toString())
            } else if (currentConversion == "cm to in") {
                outputText.setText((inputText.text.toString().toDouble() / 2.54).toString())
            } else {
                outputText.setText("")
            }
        }
    }

    override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
        currentConversion = items[position]
        val inputText = findViewById<View>(R.id.inputText) as EditText
        val outputText = findViewById<View>(R.id.outputText) as EditText
        inputText.setText("")
        outputText.setText("")
    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {
        // TODO Auto-generated method stub
    }
}
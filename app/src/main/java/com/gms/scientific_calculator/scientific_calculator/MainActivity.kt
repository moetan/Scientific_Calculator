package com.gms.scientific_calculator.scientific_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ExpandableListAdapter
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answer = findViewById<TextView>(R.id.field) as TextView
        val clearButton = findViewById<Button>(R.id.clearButton) as Button
        val button1 = findViewById<Button>(R.id.button1)  as Button
        val button2 = findViewById<Button>(R.id.button2)  as Button
        val button3 = findViewById<Button>(R.id.button3)  as Button
        val addButton = findViewById<Button>(R.id.add).setOnClickListener { answer.append("+") }
        val enter = findViewById<Button>(R.id.enter).setOnClickListener { answer.text = calc(answer).toString() }

        clearButton.setOnClickListener { clear(answer) }
        button1.setOnClickListener { answer.append("1") }
        button2.setOnClickListener { answer.append("2") }
        button3.setOnClickListener { answer.append("3") }
    }

    fun clear(text: TextView) {
        text.text = null
    }

    val calc = { t: TextView ->
        Expression(t.toString()).calculate()
    }


}
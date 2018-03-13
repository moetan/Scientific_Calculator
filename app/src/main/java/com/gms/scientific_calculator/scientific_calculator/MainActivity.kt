package com.gms.scientific_calculator.scientific_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ExpandableListAdapter
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression
import org.w3c.dom.Text
import java.lang.Double.NaN

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answer = findViewById<TextView>(R.id.field)
        val solution = findViewById<TextView>(R.id.answer)
        clear(answer)
        clear(solution)
        setOnClicks(answer, solution)
    }

    fun clear(text: TextView) {
        text.text = null
    }

    fun onEnter(answerFiled: TextView, solutionField: TextView) {
        val exp = answerFiled.text
        val sol = Expression(exp.toString()).calculate()
        var answer = ""

        answer = if (sol.equals(NaN)) "ERROR"
        else "$exp = $sol"

        clear(answerFiled)
        solutionField.text = answer
    }

    fun setOnClicks(answer: TextView, solutionField: TextView) {
        findViewById<Button>(R.id.button1).setOnClickListener { answer.append("1") }
        findViewById<Button>(R.id.button2).setOnClickListener { answer.append("2") }
        findViewById<Button>(R.id.button3).setOnClickListener { answer.append("3") }
        findViewById<Button>(R.id.button4).setOnClickListener { answer.append("4") }
        findViewById<Button>(R.id.button5).setOnClickListener { answer.append("5") }
        findViewById<Button>(R.id.button6).setOnClickListener { answer.append("6") }
        findViewById<Button>(R.id.button7).setOnClickListener { answer.append("7") }
        findViewById<Button>(R.id.button8).setOnClickListener { answer.append("8") }
        findViewById<Button>(R.id.button9).setOnClickListener { answer.append("9") }
        findViewById<Button>(R.id.button10).setOnClickListener { answer.append("0") }

        findViewById<Button>(R.id.add).setOnClickListener { answer.append("+") }
        findViewById<Button>(R.id.minusButton).setOnClickListener { answer.append("-") }
        findViewById<Button>(R.id.timesButton).setOnClickListener { answer.append("*") }
        findViewById<Button>(R.id.divide).setOnClickListener { answer.append("/") }

        findViewById<Button>(R.id.pi).setOnClickListener { answer.append("pi") }

        findViewById<Button>(R.id.openPara).setOnClickListener { answer.append("(") }
        findViewById<Button>(R.id.closePara).setOnClickListener { answer.append(")") }
        findViewById<Button>(R.id.enter).setOnClickListener{ onEnter(answer, solutionField)}

        findViewById<Button>(R.id.clearButton).setOnClickListener { answer.text = null }

        findViewById<Button>(R.id.delete).setOnClickListener { delete(answer) }

        findViewById<Button>(R.id.dot).setOnClickListener { answer.append(".") }
    }

    fun delete(answer: TextView) {
        try {
            val updateText = answer.text.toString().substring(1)
            answer.text = updateText
        } catch (ex: IndexOutOfBoundsException) {
            return
        }
    }

}
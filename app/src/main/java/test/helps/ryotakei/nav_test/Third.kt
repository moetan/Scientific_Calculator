package test.helps.ryotakei.nav_test

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression
import kotlin.Double.Companion.NaN



class Third : Fragment() {
    lateinit var myView: View
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myview = inflater!!.inflate(R.layout.third_layout, container, false)
        initElements()
        return myView
    }

    fun TextView.clear() { // extension method for TextView class. clears up text in the TextView
        this.text = null
    }


    fun onEnter(answerFiled: TextView, solutionField: TextView) {
        val exp = answerFiled.text  // getting expression from answerField
        val sol = Expression(exp.toString()).calculate() // calculating answer of the expression
        var answer = if (sol.equals(NaN)) "ERROR" else "$exp = $sol" // answer will be "ERROR" if the 'sol' variable is NaN

        answerFiled.clear()
        solutionField.text = answer // append answer to solutionField
    }

    fun initButtons(mathField: TextView, solutionField: TextView) {
        myView.findViewById<Button>(R.id.button1).setOnClickListener { mathField.append("1") }
        myView.findViewById<Button>(R.id.button2).setOnClickListener { mathField.append("2") }
        myView.findViewById<Button>(R.id.button3).setOnClickListener { mathField.append("3") }
        myView.findViewById<Button>(R.id.button4).setOnClickListener { mathField.append("4") }
        myView.findViewById<Button>(R.id.button5).setOnClickListener { mathField.append("5") }
        myView.findViewById<Button>(R.id.button6).setOnClickListener { mathField.append("6") }
        myView.findViewById<Button>(R.id.button7).setOnClickListener { mathField.append("7") }
        myView.findViewById<Button>(R.id.button8).setOnClickListener { mathField.append("8") }
        myView.findViewById<Button>(R.id.button9).setOnClickListener { mathField.append("9") }
        myView.findViewById<Button>(R.id.button10).setOnClickListener { mathField.append("0") }
        myView.findViewById<Button>(R.id.tipavgservice).setOnClickListener { mathField.append("*.15") }
        myView.findViewById<Button>(R.id.tipgreatservice).setOnClickListener { mathField.append("*.20") }
        myView.findViewById<Button>(R.id.tipbadservice).setOnClickListener { mathField.append("*.10") }
        myView.findViewById<Button>(R.id.inchtocm).setOnClickListener { mathField.append("*2.54") }
        myView.findViewById<Button>(R.id.ibtokg).setOnClickListener { mathField.append("*.4536") }
        myView.findViewById<Button>(R.id.oztomL).setOnClickListener { mathField.append("*29.5735") }
        myView.findViewById<Button>(R.id.mitokm).setOnClickListener { mathField.append("*1.60934") }
        myView.findViewById<Button>(R.id.enter).setOnClickListener{ onEnter(mathField, solutionField)}
        myView.findViewById<Button>(R.id.clearButton).setOnClickListener { mathField.clear() }
        myView.findViewById<Button>(R.id.delete).setOnClickListener { delete(mathField) }
        myView.findViewById<Button>(R.id.dot).setOnClickListener { mathField.append(".") }


    fun initElements() {
        val mathField: TextView = myView.findViewById<TextView>(R.id.mathField)
        val answerField = myView.findViewById<TextView>(R.id.answerField)
        initButtons(mathField, answerField)
    }
    /**
     * called when "DEL" button is pressed
     * Deletes one char from TextView
     * @param field TextView
     */
    fun delete(field: TextView) {
        try {
            val updateText = field.text.toString().substring(1) // takes everything but last char in the TextView
            field.text = updateText // append the text
        } catch (ex: IndexOutOfBoundsException) { // need this when length is 0(aka null)
            return // if it gives me IndexOutOfBoundsException, I don't care, it just means it's empty, return it.
        }
    }
}


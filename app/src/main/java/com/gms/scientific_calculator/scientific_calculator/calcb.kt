package test.helps.ryotakei.nav_test

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.Double.Companion.NaN
import org.mariuszgromada.math.mxparser.Expression




class CalcFragment: Fragment() {
    lateinit var myView: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater!!.inflate(R.layout.calc_layout, container, false)
        initElements()
        return myView
    }

    fun TextView.clear() { // extension method for TextView class. clears up text in the TextView
        this.text = null
    }
    
    fun onEnter(answerFiled: TextView, solutionField: TextView) {
        val exp = answerFiled.text  // getting expression from answerField
        val sol = Expression(exp.toString()).calculate() 
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
        myView.findViewById<Button>(R.id.add).setOnClickListener { mathField.append("+") }
        myView.findViewById<Button>(R.id.minusButton).setOnClickListener { mathField.append("-") }
        myView.findViewById<Button>(R.id.timesButton).setOnClickListener { mathField.append("*") }
        myView.findViewById<Button>(R.id.divide).setOnClickListener { mathField.append("/") }
        myView.findViewById<Button>(R.id.pi).setOnClickListener { mathField.append("pi") }
        myView.findViewById<Button>(R.id.openPara).setOnClickListener { mathField.append("(") }
        myView.findViewById<Button>(R.id.closePara).setOnClickListener { mathField.append(")") }
        myView.findViewById<Button>(R.id.enter).setOnClickListener{ onEnter(mathField, solutionField)}
        myView.findViewById<Button>(R.id.clearButton).setOnClickListener { mathField.clear() }
        myView.findViewById<Button>(R.id.delete).setOnClickListener { delete(mathField) }
        myView.findViewById<Button>(R.id.dot).setOnClickListener { mathField.append(".") }
    }

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
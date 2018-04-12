//package com.gms.scientific_calculator.scientific_calculator
//
//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import org.mariuszgromada.math.mxparser.Expression
//import java.lang.Double.NaN
//
//class MainActivity : AppCompatActivity() {
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val mathField = findViewById<TextView>(R.id.mathField) // creating mathField
//        val answerField = findViewById<TextView>(R.id.answerField) // creating answerField
//        listOf(mathField, answerField).forEach { it.clear() } // calling clear() for both fields.
//        initButtons(mathField, answerField)
//    }
//
//    fun TextView.clear() { // extension method for TextView class. clears up text in the TextView
//        this.text = null
//    }
//
//    /**
//     * called when "Enter" is pressed.
//     * @param answerFiled TextView that shows math equations
//     * @param solutionField TextView that shows the answer. The format is "equation = answer"
//     * @return append "equation = answer" String to solutionField. "ERROR" if the answer is NaN
//     */
//    fun onEnter(answerFiled: TextView, solutionField: TextView) {
//        val exp = answerFiled.text  // getting expression from answerField
//        val sol = Expression(exp.toString()).calculate() // calculating answer of the expression
//        var answer = if (sol.equals(NaN)) "ERROR" else "$exp = $sol" // answer will be "ERROR" if the 'sol' variable is NaN
//
//        answerFiled.clear()
//        solutionField.text = answer // append answer to solutionField
//    }
//
//    /**
//     * All it does is initialize buttons.
//     * setOnClickListener takes lambda
//     * Not storing them to variables. Less memory usage. haha
//     *
//     * @param mathField TextView which shows equation
//     * @param solutionField TextView which shows answer of the equation
//     */
//    fun initButtons(mathField: TextView, solutionField: TextView) {
//        findViewById<Button>(R.id.button1).setOnClickListener { mathField.append("1") }
//        findViewById<Button>(R.id.button2).setOnClickListener { mathField.append("2") }
//        findViewById<Button>(R.id.button3).setOnClickListener { mathField.append("3") }
//        findViewById<Button>(R.id.button4).setOnClickListener { mathField.append("4") }
//        findViewById<Button>(R.id.button5).setOnClickListener { mathField.append("5") }
//        findViewById<Button>(R.id.button6).setOnClickListener { mathField.append("6") }
//        findViewById<Button>(R.id.button7).setOnClickListener { mathField.append("7") }
//        findViewById<Button>(R.id.button8).setOnClickListener { mathField.append("8") }
//        findViewById<Button>(R.id.button9).setOnClickListener { mathField.append("9") }
//        findViewById<Button>(R.id.button10).setOnClickListener { mathField.append("0") }
//        findViewById<Button>(R.id.add).setOnClickListener { mathField.append("+") }
//        findViewById<Button>(R.id.minusButton).setOnClickListener { mathField.append("-") }
//        findViewById<Button>(R.id.timesButton).setOnClickListener { mathField.append("*") }
//        findViewById<Button>(R.id.divide).setOnClickListener { mathField.append("/") }
//        findViewById<Button>(R.id.pi).setOnClickListener { mathField.append("pi") }
//        findViewById<Button>(R.id.openPara).setOnClickListener { mathField.append("(") }
//        findViewById<Button>(R.id.closePara).setOnClickListener { mathField.append(")") }
//        findViewById<Button>(R.id.enter).setOnClickListener{ onEnter(mathField, solutionField)}
//        findViewById<Button>(R.id.clearButton).setOnClickListener { mathField.clear() }
//        findViewById<Button>(R.id.delete).setOnClickListener { delete(mathField) }
//        findViewById<Button>(R.id.dot).setOnClickListener { mathField.append(".") }
//    }
//
//    /**
//     * called when "DEL" button is pressed
//     * Deletes one char from TextView
//     * @param field TextView
//     */
//    fun delete(field: TextView) {
//        try {
//            val updateText = field.text.toString().substring(1) // takes everything but last char in the TextView
//            field.text = updateText // append the text
//        } catch (ex: IndexOutOfBoundsException) { // need this when length is 0(aka null)
//            return // if it gives me IndexOutOfBoundsException, I don't care, it just means it's empty, return it.
//        }
//    }
//
//
//    /**
//     * a bit smart version of 'delete" method
//     * delete chars from the end
//     * @param numOfCharToDelete number of chars you want to delete from TextView
//     *
//     * It does support delete-more-than-one-char, it's a bit slow, so I'd just use delete method
//     */
//    fun TextView.delete(numOfCharToDelete: Int) {
//        if (numOfCharToDelete >= this.length()) this.text = null
//        try {
//            this.text.toString().substring(numOfCharToDelete)
//        } catch (ex: IndexOutOfBoundsException){
//            return
//        }
//    }
//
//}
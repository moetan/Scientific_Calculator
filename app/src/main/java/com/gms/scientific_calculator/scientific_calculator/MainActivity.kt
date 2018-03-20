package com.gms.scientific_calculator.scientific_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setOnclicks(){
        findViewById<Button>(R.id.calculate_button).setOnClickListener(/**something about fragments*/)
        findViewById<Button>(R.id.graph_button).setOnClickListener(/**something about fragments*/)
        findViewById<Button>(R.id.function_button).setOnClickListener(/**something about fragments*/)
        findViewById<Button>(R.id.tools_button).setOnClickListener(/**something about fragments*/)
        findViewById<Button>(R.id.games_button).setOnClickListener(/**something about fragments*/)
    }
}

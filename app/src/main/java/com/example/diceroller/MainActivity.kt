package com.example.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button1)
        rollButton.setOnClickListener{
            rollDice()
        }
        val radio_rg : RadioGroup = findViewById(R.id.group1)
        val radio2 :RadioButton = findViewById(R.id.no2)
        radio_rg.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            when (radio) {
                radio2 -> {
                    val intent = Intent(this, twoDices::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivityForResult(intent, 0);
                    overridePendingTransition(0,0);
                }

            }
        }

    }

    private fun rollDice() {
        var diceInt = Random().nextInt(6)+1;
        val diceRoll = when (diceInt){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        val diceImage : ImageView = findViewById(R.id.dice1)
        diceImage.setImageResource(diceRoll)
    }
}
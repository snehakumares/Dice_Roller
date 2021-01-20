package com.example.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import java.util.*

class twoDices : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_dices)
        val rollButton: Button = findViewById(R.id.roll_button1)
        rollButton.setOnClickListener{
            rollDice()
        }
        val radio_rg : RadioGroup = findViewById(R.id.group1)
        val radio1 :RadioButton = findViewById(R.id.no1)
        radio_rg.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            when (radio) {
                radio1 -> {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivityForResult(intent, 0);
                    overridePendingTransition(0,0);
                }

            }
        }
    }

    private fun rollDice() {
        var diceInt1 = Random().nextInt(6)+1;
        val diceRoll1 = when (diceInt1){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        val diceImage1 : ImageView = findViewById(R.id.dice1)
        diceImage1.setImageResource(diceRoll1)
        var diceInt2 = Random().nextInt(6)+1;
        val diceRoll2 = when (diceInt2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        val diceImage2 : ImageView = findViewById(R.id.dice2)
        diceImage2.setImageResource(diceRoll2)
    }
}
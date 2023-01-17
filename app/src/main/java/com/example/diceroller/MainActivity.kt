package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_btn)
        //rollButton.text = "Let's Roll"

        /*
        rollButton.setOnClickListener {
            Toast.makeText(this,"Button Clicked", Toast.LENGTH_SHORT).show()
        }
        */
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        //val resultText: TextView = findViewById(R.id.result_txt)
        val randomInt = Random.nextInt(6)+1

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
        //resultText.text= randomInt.toString()
    }
}
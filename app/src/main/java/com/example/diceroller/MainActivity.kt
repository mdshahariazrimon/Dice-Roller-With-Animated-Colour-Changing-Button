package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color


class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
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

        val colorAnim = ObjectAnimator.ofObject(rollButton, "backgroundColor", ArgbEvaluator(),
            Color.RED, Color.BLUE)
        colorAnim.duration = 3000 // animation will take 3 sec
        colorAnim.repeatCount = ObjectAnimator.INFINITE
        colorAnim.repeatMode = ObjectAnimator.REVERSE

        // Start the animation when the button is clicked
        rollButton.setOnClickListener {
            colorAnim.start()
            rollDice()
        }
        diceImage=findViewById(R.id.dice_image)
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
        //val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
        //resultText.text= randomInt.toString()
    }
}
package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import java.util.Random

class MainActivity : AppCompatActivity() {
    // here we declare a lateinit variable. this tells kotlin that we promise to make sure the
    // variable is initialized with a value before using it. Therefore we don't need to perform
    // null checks or set this as a nulllable variable.
    lateinit var diceImage: ImageView
    lateinit var rollResultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        diceImage = findViewById(R.id.roll_result_image)
        rollResultText = findViewById(R.id.roll_result_text)

        // apparently when you put a lambda after a method like this, the compiler reads this as an
        // invocation of the method
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1

        val diceImageToDisplay = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        rollResultText.text = "$randomInt"
        diceImage.setImageResource(diceImageToDisplay)
    }
}
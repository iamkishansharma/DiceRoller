package com.ks.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    //or var diceImage: ImageView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{
            Toast.makeText(this,"button Clicked",Toast.LENGTH_SHORT).show()

            rollDice()
        }

        diceImage= findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val drawableResource = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        dice_image.setImageResource(drawableResource)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val i = item.itemId
        when(i){
            R.id.m1 -> Toast.makeText(this,item.title,Toast.LENGTH_SHORT).show()
            R.id.m2 -> {
                startActivity(Intent(this@MainActivity,PdfActivity::class.java))
            }
            else -> return false
        }
        return true
    }
}

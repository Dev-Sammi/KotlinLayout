package com.example.kotlinlayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        configureLayout()
    }

    private fun configureLayout() {
        val myButton = Button(this)
        myButton.text = getString(R.string.press_me)
        myButton.setBackgroundColor(Color.YELLOW)
        myButton.id = R.id.myButton

        val myEditText = EditText(this)
        myEditText.id = R.id.myEditText

        val myLayout = ConstraintLayout(this)
        myLayout.setBackgroundColor(Color.BLUE)
        myLayout.addView(myButton)
        myLayout.addView(myEditText)
        setContentView(myLayout)


        val set = ConstraintSet()

        set.constrainHeight(myButton.id,ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myButton.id,ConstraintSet.WRAP_CONTENT)
        set.constrainHeight(myEditText.id,ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myEditText.id,ConstraintSet.WRAP_CONTENT)

        set.connect(myButton.id, ConstraintSet.START,
            ConstraintSet.PARENT_ID, ConstraintSet.START, 0)
        set.connect(myButton.id, ConstraintSet.END,
            ConstraintSet.PARENT_ID, ConstraintSet.END, 0)
        set.connect(myButton.id, ConstraintSet.TOP,
            ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        set.connect(myButton.id, ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
        set.applyTo(myLayout)
    }
}
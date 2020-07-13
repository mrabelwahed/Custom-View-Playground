package com.ramadan.customviewplayground.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class LineAnimationView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleInt: Int = 0
) : View(context, attributeSet, defStyleInt) {
    init {
        startAnimation()
    }

    var posX = 0f
    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f, height / 2f, posX, height / 2f, paint)
    }

    private fun startAnimation() {
        removeCallbacks(animateLine)
        post(animateLine)
    }

    private val animateLine: Runnable = object : Runnable {
        override fun run() {

            // boolean to keep track if the end of screen is reached
            // animaton stops when screen end is reached
            var reachedEnd = false

            //increase x coordinate by 10 till the end of screen is reached
            if (posX < width) posX += 10 else reachedEnd = true

            //keep the runnable running till the end of screen is reached
            if (!reachedEnd) {
                //run every 15 milliseconds
                postDelayed(this, 15)
            }

            //finally call invalidate()- this will call the onDraw() method
            invalidate()
        }
    }
}
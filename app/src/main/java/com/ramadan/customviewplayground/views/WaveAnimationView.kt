package com.ramadan.customviewplayground.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlin.math.sin

class WaveAnimationView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleInt: Int = 0
) : View(context, attributeSet, defStyleInt) {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val PI2 = Math.PI *2
    val path = Path()

    init {
        paint.strokeWidth = 4f
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
         calculatePath()
        canvas?.drawPath(path,paint)
    }

    private fun calculatePath() {
        path.reset()
        path.moveTo(0f, 800f)
        var y: Float
        for (x in 0..width) {
            y = (150 * Math.sin(PI2 / (width / 4) * x) + 800).toFloat()
            path.lineTo(x.toFloat(), y)
        }
    }
}
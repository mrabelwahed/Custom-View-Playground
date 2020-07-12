package com.ramadan.customviewplayground.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.ramadan.customviewplayground.R
import kotlin.math.min

class PizzaView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleInt: Int = 0
) : View(context, attributeSet, defStyleInt) {

    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var numOfCuts = 5

    init {
        var strokeWidth = 4
        var pizzaColor = Color.YELLOW
        attributeSet?.let {
            val typedArray = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.PizzaView
            )

            strokeWidth =
                typedArray.getDimensionPixelSize(R.styleable.PizzaView_stroke_width, strokeWidth)
            pizzaColor = typedArray.getColor(R.styleable.PizzaView_color, pizzaColor)
            numOfCuts = typedArray.getInt(R.styleable.PizzaView_num_widget, numOfCuts)
        }
        paint.strokeWidth = strokeWidth.toFloat()
        paint.color = pizzaColor
        paint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        val w = width - (paddingLeft + paddingRight).toFloat()
        val h = height - (paddingTop + paddingBottom).toFloat()
        val r = (min(w, h) - paint.strokeWidth) / 2.toFloat()
        val cx = w / 2 + paddingLeft.toFloat()
        val cy = h / 2 + paddingTop.toFloat()
        canvas?.drawCircle(cx, cy, r, paint)
        canvas?.let { drawPizzaCuts(it, cx, cy, r) }
    }

    private fun drawPizzaCuts(canvas: Canvas, cx: Float, cy: Float, radius: Float) {
        val degree = 360f / numOfCuts
        canvas.save()
        for (i in 0 until numOfCuts) {
            canvas.rotate(degree, cx, cy)
            canvas.drawLine(cx, cy, cx, cy - radius, paint)
        }
        canvas.restore()

    }
}
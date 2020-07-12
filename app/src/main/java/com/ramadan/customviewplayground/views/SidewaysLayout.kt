package com.ramadan.customviewplayground.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout

class SidewaysLayout @JvmOverloads constructor(context: Context ,
attributeSet: AttributeSet? = null,
defStyleInt:Int =0) : LinearLayout(context,attributeSet,defStyleInt) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredHeight, measuredWidth)
    }

    override fun dispatchDraw(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, height.toFloat())
        canvas?.rotate(-90f)
        super.dispatchDraw(canvas)
        canvas?.restore()
    }
}
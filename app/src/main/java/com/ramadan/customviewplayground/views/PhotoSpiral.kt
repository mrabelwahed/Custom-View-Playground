package com.ramadan.customviewplayground.views

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class PhotoSpiral @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ViewGroup(context, attributeSet, defStyleAttr, defStyleRes) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        val first = getChildAt(0)
        val size = first.measuredWidth + first.measuredHeight
        val width = ViewGroup.resolveSize(size, widthMeasureSpec)
        val height = ViewGroup.resolveSize(size, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val first = getChildAt(0);
        val childWidth = first.measuredWidth;
        val childHeight = first.measuredHeight
        for (i in 0 until childCount) {
            var view = getChildAt(i)
            var x = 0
            var y = 0
            when (i) {
                1 -> {
                    x = childWidth
                    y = 0
                }
                2 -> {
                    x = childHeight
                    y = childWidth
                }
                3 -> {
                    x = 0
                    y = childHeight
                }
            }
            view.layout(
                x,
                y,
                x+view.measuredWidth,
                y+view.measuredHeight
            )
        }
    }


}




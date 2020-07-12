package com.ramadan.customviewplayground.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.ramadan.customviewplayground.R
import kotlinx.android.synthetic.main.view_list_picker.view.*

class LengthPicker @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attributeSet, defStyleAttr) {
    init {
        setupView()
    }

    private var counter = 0
    private lateinit var listener: OnCounterChanged

    private fun setupView() {
        val inflater = LayoutInflater.from(context)
        val view =  inflater.inflate(R.layout.view_list_picker,this)
        view.enc.setOnClickListener {
            value.text = counter++.toString()
            listener.onChange(counter)
        }
        view.dec.setOnClickListener {
            value.text = counter--.toString()
            listener.onChange(counter)
        }
    }

   fun setCounterListener(listener:OnCounterChanged){
       this.listener = listener
   }

    interface  OnCounterChanged{
        fun onChange(count:Int)
    }

}
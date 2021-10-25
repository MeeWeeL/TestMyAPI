package com.meeweel.testmyapi.catsomview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class MyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
        scaleType = ScaleType.FIT_CENTER
    }
}
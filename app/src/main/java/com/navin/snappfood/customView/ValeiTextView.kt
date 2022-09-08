package com.navin.snappfood.customView

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.graphics.Typeface
import android.util.AttributeSet

class ValeiTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {
        setFont(context)
    }

    private fun setFont(context: Context) {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/IRANSans_Bold.ttf")
        setTypeface(typeface)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setFont(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setFont(context)
    }
}
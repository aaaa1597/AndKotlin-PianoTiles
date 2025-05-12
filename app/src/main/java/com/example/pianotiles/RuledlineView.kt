package com.example.pianotiles

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RuledlineView : View {
    /* Viewを継承するときのお約束 */
    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    private val _paint: Paint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 2f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLines(floatArrayOf(
                (width*1/4).toFloat(), 0f, (width*1/4).toFloat(), height.toFloat(),
                (width*2/4).toFloat(), 0f, (width*2/4).toFloat(), height.toFloat(),
                (width*3/4).toFloat(), 0f, (width*3/4).toFloat(), height.toFloat()), _paint)
    }
}
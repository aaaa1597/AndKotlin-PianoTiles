package com.example.pianotiles

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

class  TileView: View {
    /* Viewを継承するときのお約束 */
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    /* 独自コンストラクタ */
    constructor(context: Context, tile: Tile) : super(context) {
        init(tile)
    }

    private var _color: Int = Color.BLACK
    private var _soundId: Int = 0
    /* init */
    private fun init(tile: Tile) {
        layoutParams = FrameLayout.LayoutParams(tile.width.toInt(), (tile.height*tile.rows).toInt())
//        translationX = tile.width  * tile.column
        translationX = 100f
//        translationY = -tile.height* tile.rows
        translationY = 100f
        _color = when(tile.column) {
            1 -> Color.BLACK
            2 -> Color.YELLOW
            3 -> Color.GREEN
            4 -> Color.BLUE
            else -> Color.RED
        }
        _soundId = tile.soundId
    }

    /* onDraw */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(_color)
    }

    /* ワーニング対応 onTouchEvent()をoverrideしたら、performClick()を呼ばんといかんらしい　*/
    override fun performClick(): Boolean = super.performClick()
    /* 自身をタッチされたら音を鳴らして自身を消す */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)
        if(event.action == MotionEvent.ACTION_DOWN) {
            /* 自身を消す */
            (this.parent as ViewGroup).removeView(this)
            /* 音を鳴らす */
            /* TODO: 音を鳴らす */
            return true
        }
        return performClick()
    }
}
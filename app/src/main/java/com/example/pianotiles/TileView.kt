package com.example.pianotiles

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.media.MediaPlayer
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import com.example.pianotiles.GameLevel.*

class  TileView: View {
    /* Viewを継承するときのお約束 */
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    /* 独自コンストラクタ */
    constructor(context: Context, tile: Tile, screenH: Float, level: GameLevel) : super(context) { init(tile, screenH, level)}

    private var _bgcolor: Int = Color.BLACK
    private lateinit var _mediaPlayer:MediaPlayer
    private lateinit var _anim:ObjectAnimator
    private var _OnReachEdgeCallback: OnReachEdgeCallback? = null
    /* init */
    private fun init(tile: Tile, screenH: Float, level: GameLevel) {
        layoutParams = FrameLayout.LayoutParams(tile.width.toInt(), (tile.height*tile.rows).toInt())
        translationX = tile.width  * tile.column
        translationY = -(tile.height*tile.rows) + 200
        _bgcolor = when(tile.rows) {
            1 -> Color.BLACK
            2 -> Color.YELLOW
            3 -> Color.GREEN
            4 -> Color.BLUE
            else -> Color.RED
        }
        _mediaPlayer = MediaPlayer.create(context, tile.resId)
        _mediaPlayer.setOnCompletionListener { _mediaPlayer.release() }

        _anim = ObjectAnimator.ofFloat(this, "translationY", (screenH*0.995).toFloat()).apply {
            duration = when(level) {
                easy  -> PERIODIC_TIME_EASY.toLong()
                normal-> PERIODIC_TIME_NORMAL.toLong()
                hard  -> PERIODIC_TIME_HARD.toLong()
            }
            interpolator = LinearInterpolator()
            start()
            addListener(object: Animator.AnimatorListener {
                override fun onAnimationEnd(animator: Animator) {
                    removeAllListeners()
                    /* Callbackコール */
                    _OnReachEdgeCallback?.onReachEdge()
                }
                override fun onAnimationStart(animator: Animator) { }
                override fun onAnimationCancel(animator: Animator) { }
                override fun onAnimationRepeat(animator: Animator) { }
            })
        }
    }

    /* onDraw */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(_bgcolor)
    }

    /* ワーニング対応 onTouchEvent()をoverrideしたら、performClick()を呼ばんといかんらしい　*/
    override fun performClick(): Boolean = super.performClick()
    /* 自身をタッチされたら音を鳴らして自身を消す */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)
        if(event.action == MotionEvent.ACTION_DOWN) {
            /* 自身を消す */
            _anim.pause()
            (this.parent as ViewGroup).removeView(this)
            /* 音を鳴らす */
            _mediaPlayer.start()
            return true
        }
        return performClick()
    }

    fun setOnReachEdgeCallback(onReachEdgeCallback: OnReachEdgeCallback) {
        _OnReachEdgeCallback = onReachEdgeCallback
    }

    fun pause() {
        _anim.pause()
    }

    fun resume() {
        _anim.resume()
    }

    interface OnReachEdgeCallback {
        fun onReachEdge()
    }
}

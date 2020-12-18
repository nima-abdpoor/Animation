package com.nima.animation

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd

class MainActivity : AppCompatActivity() {
    var duration = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton: ImageButton = findViewById(R.id.button_field)
        val valueAnimator0 = ValueAnimator.ofFloat(0f, -40f)
        val valueAnimator1 = ValueAnimator.ofFloat(0f, 5 * 360f)
        val valueAnimator2 = ValueAnimator.ofFloat(0f, 4 * 360f)
        val valueAnimator3 = ValueAnimator.ofFloat(0f, 3 * 360f)
        val valueAnimator4 = ValueAnimator.ofFloat(0f, 2 * 180f)
        val valueAnimator5 = ValueAnimator.ofFloat(0f, 2 * 180f)
        val valueAnimator6 = ValueAnimator.ofFloat(0f, 1 * 180f)
        val valueAnimators = listOf<ValueAnimator>(valueAnimator1, valueAnimator2, valueAnimator3, valueAnimator4, valueAnimator5, valueAnimator6)
        valueAnimator0.addUpdateListener {
            val value = it.animatedValue as Float
            myButton.rotation = value
        }
        valueAnimator0.interpolator = LinearInterpolator()
        valueAnimator0.duration = 1500L
        valueAnimator1.addUpdateListener {
            val value = it.animatedValue as Float
            myButton.rotation = value
        }
        valueAnimator2.addUpdateListener {
            val value = it.animatedValue as Float
            myButton.rotation = value
        }
        valueAnimator3.addUpdateListener {
            val value = it.animatedValue as Float
            myButton.rotation = value
        }
        valueAnimator4.addUpdateListener {
            val value = it.animatedValue as Float
            myButton.rotation = value
        }
        valueAnimator5.addUpdateListener {
            val value = it.animatedValue as Float
            myButton.rotation = value
        }
        valueAnimator6.addUpdateListener {
            val value = it.animatedValue as Float
            myButton.rotation = value
        }
        for (i in valueAnimators) {
            i.interpolator = LinearInterpolator()
            i.duration = duration / 2
        }
        valueAnimator0.start()
        valueAnimator0.doOnEnd {
            valueAnimator6.start()
            valueAnimator6.doOnEnd {
                valueAnimator5.start()
                valueAnimator5.doOnEnd {
                    valueAnimator4.start()
                    valueAnimator4.doOnEnd {
                        valueAnimator3.start()
                        valueAnimator3.doOnEnd {
                            valueAnimator2.start()
                            valueAnimator2.doOnEnd {
                                valueAnimator1.doOnEnd {
                                    valueAnimator6.start()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



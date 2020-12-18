package com.nima.animation

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    var duration = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton: ImageButton = findViewById(R.id.button_field)
        val valueAnimator1 = ValueAnimator.ofFloat(0f, 5 * 360f)
        val valueAnimator2 = ValueAnimator.ofFloat(0f, 4 * 360f)
        val valueAnimator3 = ValueAnimator.ofFloat(0f, 3 * 360f)
        val valueAnimator4 = ValueAnimator.ofFloat(0f, 2 * 360f)
        val valueAnimator5 = ValueAnimator.ofFloat(0f, 1 * 360f)
        val valueAnimators = listOf<ValueAnimator>(valueAnimator1, valueAnimator2, valueAnimator3, valueAnimator4, valueAnimator5)
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
        for (i in valueAnimators) {
            i.interpolator = LinearInterpolator()
            i.duration = duration / 2
        }
        valueAnimator1.start()
        valueAnimator1.doOnEnd {
            valueAnimator2.start()
            valueAnimator2.doOnEnd {
                valueAnimator3.start()
                valueAnimator3.doOnEnd {
                    valueAnimator4.start()
                    valueAnimator4.doOnEnd {
                        valueAnimator5.start()
                        valueAnimator5.doOnEnd {
                            for (i in valueAnimators) {
                                i.interpolator = LinearInterpolator()
                                i.duration = duration * 2
                            }
                            valueAnimator5.start()
                            valueAnimator5.doOnEnd {
                                valueAnimator4.start()
                                valueAnimator4.doOnEnd {
                                    valueAnimator3.start()
                                    valueAnimator3.doOnEnd {
                                        valueAnimator2.start()
                                        valueAnimator2.doOnEnd {
                                            valueAnimator1.start()
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


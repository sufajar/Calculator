package com.sufajar.calculator

import android.view.View

interface ProsessCalculator {
    fun onDigit(view: View)
    fun onOperator(view: View)
    fun onClear(view: View)
    fun onEqual(view: View)
    fun onBreaketStart(view: View)
    fun onBreaketEnd(view: View)
    fun onDecimal(view: View)
    fun onDelete(view: View)

}
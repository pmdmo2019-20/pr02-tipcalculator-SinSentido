package es.iessaladillo.pedrojoya.tipcalculator.model

import java.lang.IllegalArgumentException


// TipCalculator class. Its constructor receives bill, percentage and diners
class TipCalculator (bill: Float, percentage: Float, diners: Int){
    var bill: Float = bill
    var percentage: Float = percentage
    var diners: Int = diners

    init {
        if(bill < 0 || percentage < 0 || diners <= 0){
            throw IllegalArgumentException()
        }
    }

    fun calculateTip(): Float {
        return (bill/100)*percentage
    }

    fun calculateTotal(): Float {
        return bill + calculateTip()
    }

    fun calculatePerDiner(): Float {
        return calculateTotal()/diners
    }

    fun calculatePerDinerRounded(): Float {
        return Math.ceil(calculatePerDiner().toDouble()).toFloat()
    }

}
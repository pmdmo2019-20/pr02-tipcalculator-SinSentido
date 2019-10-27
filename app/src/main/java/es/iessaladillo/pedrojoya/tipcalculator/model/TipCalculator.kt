package es.iessaladillo.pedrojoya.tipcalculator.model


// TipCalculator class. Its constructor receives bill, percentage and diners

class TipCalculator (var bill: Float, var percentage: Float, var diners: Float){

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
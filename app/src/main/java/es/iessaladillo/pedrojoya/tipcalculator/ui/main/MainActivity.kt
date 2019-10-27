package es.iessaladillo.pedrojoya.tipcalculator.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import es.iessaladillo.pedrojoya.tipcalculator.R
import es.iessaladillo.pedrojoya.tipcalculator.model.TipCalculator

class MainActivity : AppCompatActivity() {
    //EditText
    lateinit var txtBill: EditText
    lateinit var txtTip: EditText
    lateinit var txtPercentage: EditText
    lateinit var txtTotal: EditText
    lateinit var txtPerDiner: EditText
    lateinit var txtDiners: EditText
    lateinit var txtPerDinerRounded: EditText

    //Buttons
    lateinit var btnResetTip: Button
    lateinit var btnResetDiners: Button

    //TipCalculator
    lateinit var tipCalculator: TipCalculator

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()

        //Listeners
        //Setup buttons
        btnResetTip.setOnClickListener { resetTip() }
        btnResetDiners.setOnClickListener { resetDiners() }

        //Setup TextWatchers
        setupTextWatchers()

        //Set default values
        txtBill.setText(getText(R.string.defaultBill))
        txtPercentage.setText(getText(R.string.defaultPercentage))
        txtDiners.setText(getText(R.string.defaultDiners))
        txtTip.setText(getString(R.string.calculatedNumber, tipCalculator.calculateTip()))
        txtTotal.setText(getString(R.string.calculatedNumber, tipCalculator.calculateTotal()))
        txtPerDiner.setText(getString(R.string.calculatedNumber, tipCalculator.calculatePerDiner()))
        txtPerDinerRounded.setText(getString(R.string.calculatedNumber, tipCalculator.calculatePerDinerRounded()))

    }

    private fun setupViews(){
        //EditText
        txtBill = ActivityCompat.requireViewById(this, R.id.txtBill)
        txtPercentage = ActivityCompat.requireViewById(this, R.id.txtPercentage)
        txtTip = ActivityCompat.requireViewById(this, R.id.txtTip)
        txtTotal = ActivityCompat.requireViewById(this, R.id.txtTotal)
        txtDiners = ActivityCompat.requireViewById(this, R.id.txtDiners)
        txtPerDiner = ActivityCompat.requireViewById(this, R.id.txtPerDiner)
        txtPerDinerRounded = ActivityCompat.requireViewById(this, R.id.txtPerDinerRounded)

        //Button
        btnResetTip = ActivityCompat.requireViewById(this, R.id.btnResetTip)
        btnResetDiners = ActivityCompat.requireViewById(this, R.id.btnResetDiners)

        //TipCalculator
        tipCalculator = TipCalculator(getString(R.string.defaultBill).toFloat(),
            getString(R.string.defaultPercentage).toFloat(),
            getString(R.string.defaultDiners).toInt())
    }

    private fun resetDiners() {
        txtDiners.setText(getText(R.string.defaultDiners))
        txtDiners.requestFocus()
    }

    private fun resetTip() {
        txtBill.setText(getText(R.string.defaultBill))
        txtPercentage.setText(getText(R.string.defaultPercentage))
        txtBill.requestFocus()
    }

    private fun setupTextWatchers(){
        txtBill.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if(s.toString() != ""){
                    tipCalculator.bill = s.toString().toFloat()
                    txtTip.setText(getString(R.string.calculatedNumber, tipCalculator.calculateTip()))
                    txtTotal.setText(getString(R.string.calculatedNumber, tipCalculator.calculateTotal()))
                    txtPerDiner.setText(getString(R.string.calculatedNumber, tipCalculator.calculatePerDiner()))
                    txtPerDinerRounded.setText(getString(R.string.calculatedNumber, tipCalculator.calculatePerDinerRounded()))
                }
                else{
                    txtBill.setText(getText(R.string.defaultBill))
                }
            }
        })

        txtPercentage.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if(s.toString() != ""){
                    tipCalculator.percentage = s.toString().toFloat()
                    txtTip.setText(getString(R.string.calculatedNumber, tipCalculator.calculateTip()))
                    txtTotal.setText(getString(R.string.calculatedNumber, tipCalculator.calculateTotal()))
                    txtPerDiner.setText(getString(R.string.calculatedNumber, tipCalculator.calculatePerDiner()))
                    txtPerDinerRounded.setText(getString(R.string.calculatedNumber, tipCalculator.calculatePerDinerRounded()))
                }
                else{
                    txtPercentage.setText(getText(R.string.defaultPercentage))
                }
            }
        })

        txtDiners.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if(s.toString() != ""){
                    tipCalculator.diners = s.toString().toInt()
                    txtTip.setText(getString(R.string.calculatedNumber, tipCalculator.calculateTip()))
                    txtTotal.setText(getString(R.string.calculatedNumber, tipCalculator.calculateTotal()))
                    txtPerDiner.setText(getString(R.string.calculatedNumber, tipCalculator.calculatePerDiner()))
                    txtPerDinerRounded.setText(getString(R.string.calculatedNumber, tipCalculator.calculatePerDinerRounded()))
                }
                else{
                    txtDiners.setText(getText(R.string.defaultDiners))
                }
            }
        })
    }

}

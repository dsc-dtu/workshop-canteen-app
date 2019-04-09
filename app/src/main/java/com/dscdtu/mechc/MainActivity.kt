package com.dscdtu.mechc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var quantity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orderButton: Button = findViewById(R.id.btnOrder)

        orderButton.setOnClickListener {
            val name = etName.text.toString()
            val amount = calcPrice(
                cbPotato.isChecked,
                cbBhature.isChecked,
                cbRice.isChecked
            )
            val message = "Order Placed for $name, Please pay Rs. $amount"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            reset()
        }
    }

    private fun calcPrice(addPotato: Boolean, addBhature: Boolean, addRice: Boolean): Int {
        var amount = 0
        if (addPotato) {
            amount += 30
        }
        if (addBhature) {
            amount += 20
        }
        if (addRice) {
            amount += 35
        }
        return amount * quantity
    }

    fun addQuantity(view: View) {
        ++quantity
        showQuantity(quantity)
    }

    fun removeQuantity(view: View) {
        if(quantity > 1) {
            --quantity
            showQuantity(quantity)
        }
    }

    private fun showQuantity(quantity: Int) {
        tvQuantity.text = quantity.toString()
    }

    private fun reset() {
        quantity = 1
        showQuantity(quantity)
        cbPotato.isChecked = false
        cbBhature.isChecked = false
        cbRice.isChecked = false
        etName.setText("")
    }
}

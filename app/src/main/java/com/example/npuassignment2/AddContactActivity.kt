package com.example.npuassignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

    }

    override fun onStart() {
        super.onStart()
        listeners()
    }

    private fun listeners() {
        //negative icon
        negative_ic.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(getString(R.string.phone), "tel:" + et_number.text.toString())
            intent.putExtra(getString(R.string.webSite), "http:" + et_web_address.text.toString())
            intent.putExtra(
                getString(R.string.location),
                "geo:0,0?q=" + et_location.text.toString()
            )
            intent.putExtra(getString(R.string.state), ContactState.NEGATIVE)
            startActivity(intent)
        }

        //positive icon
        positive_ic.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(getString(R.string.phone), "tel:" + et_number.text.toString())
            intent.putExtra(getString(R.string.webSite), "http:" + et_web_address.text.toString())
            intent.putExtra(
                getString(R.string.location),
                "geo:0,0?q=" + et_location.text.toString()
            )
            intent.putExtra(getString(R.string.state), ContactState.POSITIVE)
            startActivity(intent)
        }

        //neutral icon
        neutral_ic.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(getString(R.string.phone), "tel:" + et_number.text.toString())
            intent.putExtra(getString(R.string.webSite), "http:" + et_web_address.text.toString())
            intent.putExtra(
                getString(R.string.location),
                "geo:0,0?q=" + et_location.text.toString()
            )
            intent.putExtra(getString(R.string.state), ContactState.NEUTRAL)
            startActivity(intent)
        }

    }
}
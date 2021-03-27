package com.example.npuassignment2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var phone: String? = null
    var webSite: String? = null
    var location: String? = null
    var state: ContactState? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        phone = intent.getStringExtra(getString(R.string.phone))
        location = intent.getStringExtra(getString(R.string.location))
        webSite = intent.getStringExtra(getString(R.string.webSite))
        state = intent.getSerializableExtra(getString(R.string.state)) as ContactState?

        listeners()
    }

    private fun listeners() {

        //create new acc
        create_btn.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }

        //phone call
        setPhone()

        //open web site
        setWebSite()

        //open location
        setLocation()

        //set state
        setState()

    }

    private fun setLocation() {
        if (location.isNullOrEmpty()) {
            location_ic.visibility = View.GONE
        } else {
            location_ic.visibility = View.VISIBLE
            try {
                location_ic.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(location)))
                }
            } catch (e: Exception) {
            }

        }
    }

    private fun setState() {
        state_ic.visibility = View.VISIBLE
        when (state) {
            ContactState.NEGATIVE -> {
                state_ic.setImageResource(R.drawable.negative_ic)
            }
            ContactState.POSITIVE -> {
                state_ic.setImageResource(R.drawable.positive_ic)
            }
            ContactState.NEUTRAL -> {
                state_ic.setImageResource(R.drawable.neutral_ic)
            }
            null -> state_ic.visibility = View.GONE
        }
    }

    private fun setWebSite() {
        if (webSite.isNullOrEmpty()) {
            web_site_ic.visibility = View.GONE
        } else {
            web_site_ic.visibility = View.VISIBLE
            try {
                web_site_ic.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(webSite)))
                }
            } catch (e: Exception) {
            }

        }
    }

    private fun setPhone() {
        if (phone.isNullOrEmpty()) {
            phone_ic.visibility = View.GONE
        } else {
            phone_ic.visibility = View.VISIBLE
            try {
                phone_ic.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(phone)))
                }
            } catch (e: Exception) {
            }
        }
    }
}
package com.example.hadi.firebasechat

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hadi.firebasechat.adapter.ChatViewPagerAdapter
import com.example.hadi.firebasechat.fragments.ContactFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContactFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var viewPagerAdapter: ChatViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (mAuth.currentUser == null){
            startActivityForResult(Intent(this, LoginActivity::class.java),
                    SIGN_IN_REQUEST_CODE)
        }

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewPagerAdapter = ChatViewPagerAdapter(supportFragmentManager)
        viewpager.adapter = viewPagerAdapter
        tab.setupWithViewPager(viewpager)

    }

    companion object {
        private const val SIGN_IN_REQUEST_CODE = 0x01
    }
}

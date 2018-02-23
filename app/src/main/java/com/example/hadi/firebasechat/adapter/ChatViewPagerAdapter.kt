package com.example.hadi.firebasechat.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.hadi.firebasechat.fragments.ContactFragment

/**
 * Created by hadi on 23/02/18.
 */
class ChatViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return ContactFragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Contact"
            1 -> "Chat"
            else -> "Info"
        }
    }
}
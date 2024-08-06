package com.example.projectrumba.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.projectrumba.R


class sign_up : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view= inflater.inflate(R.layout.fragment_sign_up, container, false)
        val haveAnAccountTextView = view.findViewById<TextView>(R.id.haveAnAccount)

        haveAnAccountTextView.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main, LogInFragment())
                ?.commit()
            activity?.findViewById<FrameLayout>(R.id.main)?.bringToFront()
        }


        return view;
    }


}
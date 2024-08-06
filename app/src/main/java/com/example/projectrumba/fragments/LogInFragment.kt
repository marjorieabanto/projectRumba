package com.example.projectrumba.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.projectrumba.R


class LogInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view= inflater.inflate(R.layout.fragment_log_in, container, false)

        val registrarseEt = view.findViewById<TextView>(R.id.Registrarse)

        registrarseEt.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main, sign_up())
                ?.commit()
            activity?.findViewById<FrameLayout>(R.id.main)?.bringToFront()
        }



    return view

    }


}
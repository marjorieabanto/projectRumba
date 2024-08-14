package com.example.projectrumba.fragments

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.projectrumba.R


class InicioFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_inicio, container, false)
        val djOption= view.findViewById<ImageView>(R.id.djOption)
        val stereoOption= view.findViewById<ImageView>(R.id.stereoOption)



        djOption.setOnClickListener(){


            djOption.setBackgroundColor(Color.parseColor("#009484"));



        }

        stereoOption.setOnClickListener(){

            stereoOption.setBackgroundColor(Color.parseColor("#009484"));

        }
        return view


    }




}
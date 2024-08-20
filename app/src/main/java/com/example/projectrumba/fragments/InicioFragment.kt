package com.example.projectrumba.fragments

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.projectrumba.R
import android.net.wifi.WifiManager
import android.widget.Toast


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


            openHotspotSettings();
            djOption.setBackgroundColor(Color.parseColor("#009484"));

            if (isHotspotEnabled()) {
                // Redirige a la HotspotActivity
                val intent =  Intent(
                    getActivity(),
                    ShareMusicActivity::class.java
                )
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Por favor, activa el hotspot", Toast.LENGTH_SHORT).show()
            }

        }

        stereoOption.setOnClickListener(){

            openHotspotSettings()
            stereoOption.setBackgroundColor(Color.parseColor("#009484"));
            val intent = Intent(
                getActivity(),
                ReceiveMusicActivity::class.java
            )
            startActivity(intent)

        }
        return view


    }


    private fun openHotspotSettings() {
        try {

            val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()

            val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
            startActivity(intent)
        }
    }

    private fun isHotspotEnabled(): Boolean {

        val wifiManager = requireContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        return try {

            val method = wifiManager.javaClass.getDeclaredMethod("isWifiApEnabled")
            method.isAccessible = true
            method.invoke(wifiManager) as Boolean
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }


}
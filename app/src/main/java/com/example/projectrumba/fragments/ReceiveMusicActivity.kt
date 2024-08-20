package com.example.projectrumba.fragments

import DeviceAdapter
import android.Manifest
import android.content.pm.PackageManager

import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectrumba.R


class ReceiveMusicActivity : AppCompatActivity() {

    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_music)


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {

            displayNearbyIPs()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                displayNearbyIPs()
            } else {
                Toast.makeText(this, "Permiso de ubicación es necesario para escanear Wi-Fi", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun displayNearbyIPs() {
        // Inicializar RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.shareRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        try {

            val nearbyIPs = getNearbyIPAddresses()


            val adapter = DeviceAdapter(nearbyIPs)
            recyclerView.adapter = adapter
        } catch (e: SecurityException) {

            Toast.makeText(this, "No se pueden obtener las redes Wi-Fi debido a la falta de permisos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getNearbyIPAddresses(): List<String> {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            throw SecurityException("Permiso de ubicación no concedido")
        }

        val wifiManager = applicationContext.getSystemService(WifiManager::class.java)
        val scanResults = wifiManager.scanResults

        val ipAddresses = mutableListOf<String>()

        for (result in scanResults) {

            ipAddresses.add("SSID: ${result.SSID}, BSSID: ${result.BSSID}")
        }

        return ipAddresses
    }
}
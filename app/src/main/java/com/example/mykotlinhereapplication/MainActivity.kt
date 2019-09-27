package com.example.mykotlinhereapplication

import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.here.android.mpa.common.GeoCoordinate
import com.here.android.mpa.common.OnEngineInitListener
import com.here.android.mpa.mapping.Map
import com.here.android.mpa.mapping.SupportMapFragment

class MainActivity : AppCompatActivity() {

    private var map : Map = Map()
    private var mapFragment : SupportMapFragment = SupportMapFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapFragment = getSupportFragmentManager().findFragmentById(R.id.mapfragment) as SupportMapFragment
        mapFragment.init { error ->
            if (error == OnEngineInitListener.Error.NONE) {
                map = mapFragment.map
                map.setCenter(GeoCoordinate(35.6620, 139.7038, 0.0), Map.Animation.NONE)
                map.zoomLevel = (map.maxZoomLevel + map.minZoomLevel) / 2
            }
        }

        // get reference to button
        val btn_click_me = findViewById(R.id.btn_click_me) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
    }
}
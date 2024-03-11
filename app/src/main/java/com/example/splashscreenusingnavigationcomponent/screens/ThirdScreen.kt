package com.example.splashscreenusingnavigationcomponent.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.splashscreenusingnavigationcomponent.R


class ThirdScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_third_screen, container, false)

        val finish = view.findViewById<TextView>(R.id.tv_finish)

        finish.setOnClickListener(){

            findNavController().navigate(R.id.action_onBoardingFragment_to_homeFragment)
            onBoardingIsFinished()
        }


        return view
    }

    private fun onBoardingIsFinished(){

        val sharedPreference = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)

        val editor = sharedPreference.edit()
        editor.putBoolean("finished",true)
        editor.apply()

    }


}
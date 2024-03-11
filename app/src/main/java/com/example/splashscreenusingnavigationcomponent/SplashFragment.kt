package com.example.splashscreenusingnavigationcomponent

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.mikhaellopez.circularimageview.CircularImageView


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //delay
        Handler(Looper.getMainLooper()).postDelayed({

            if(onBoardingIsFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)

            }else{

                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }


        },3000)

        val view = inflater.inflate(R.layout.fragment_splash, container, false)


        val animTop = AnimationUtils.loadAnimation(view.context,R.anim.from_top)
        val animBottom = AnimationUtils.loadAnimation(view.context,R.anim.from_bottom)

        val tvSplash = view.findViewById<TextView>(R.id.tv_logo)
        val tvImage = view.findViewById<CircularImageView>(R.id.circularImageView)

        tvSplash.animation = animTop
        tvImage.animation = animBottom


        return view
    }

    private fun onBoardingIsFinished():Boolean{

        val sharedPreference = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)

        return  sharedPreference.getBoolean("finished",false)

    }


}
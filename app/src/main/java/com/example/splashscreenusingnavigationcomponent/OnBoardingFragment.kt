package com.example.splashscreenusingnavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.splashscreenusingnavigationcomponent.screens.FirstScreen
import com.example.splashscreenusingnavigationcomponent.screens.SecondScreen
import com.example.splashscreenusingnavigationcomponent.screens.ThirdScreen
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class OnBoardingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_on_boarding, container, false)


        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )


        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager2)

        viewPager.adapter = adapter

        val dotsIndicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)

        dotsIndicator.attachTo(viewPager)

        return view
    }

}
package com.example.newsappspace.fragments.onboardingviewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.newsappspace.R
import com.example.newsappspace.adapters.viewpageradapter.ViewPagerAdapter
import com.example.newsappspace.basemodels.BaseFrag
import com.example.newsappspace.databinding.ViewpagerHostFragmentBinding

class ViewpagerHost : BaseFrag<ViewpagerHostFragmentBinding, ViewpagerHostViewModel>() {

    lateinit var onboardingViewpager: ViewPager2
    lateinit var myAdapter: ViewPagerAdapter
    private lateinit var navController: NavController
    var screenPos=0


    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> ViewpagerHostFragmentBinding
        get() = ViewpagerHostFragmentBinding::inflate

    override fun connectViewmodel(): Class<ViewpagerHostViewModel> =
        ViewpagerHostViewModel::class.java


    override fun init() {
        onboardingViewpager=binding.viewPager
        myAdapter=ViewPagerAdapter(this)
        onboardingViewpager.adapter=myAdapter
        navController = this.findNavController()
        setlistener()
    }

    private fun setlistener() {

        binding.nextTextView.setOnClickListener {


            onboardingViewpager.setCurrentItem(++screenPos,true)
            if (screenPos==3){
                findNavController().navigate(R.id.action_viewpagerHost_to_newsScreenFragment)
            }else if(screenPos==2){
                binding.nextTextView.text="finish"
            }
        }
    }

//    fun dsds(){
//
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.onboardingFirstFragment ->screenPos=1
//                R.id.onboarding2 -> screenPos=2
//                else -> screenPos=3
//            }
//            Toast.makeText(requireContext(), "${screenPos}", Toast.LENGTH_SHORT).show()
//        }
//    }

}
package com.example.newsappspace.adapters.viewpageradapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsappspace.fragments.onboarding.oboarding1.OnboardingFirstFragment
import com.example.newsappspace.fragments.onboarding.onboarding2.Onboarding2
import com.example.newsappspace.fragments.onboarding.onboarding3.Onboarding3


class ViewPagerAdapter(fragmentActivity: Fragment) :

    FragmentStateAdapter(fragmentActivity) {




    override fun getItemCount(): Int {
        return CARD_ITEM_SIZE
    }

    override fun createFragment(position: Int): Fragment {
        return arrayList[position]
    }

    companion object {
        const val CARD_ITEM_SIZE = 3
         var firstFragment: OnboardingFirstFragment = OnboardingFirstFragment()
        var secondFragment:Onboarding2= Onboarding2()
        var thirdFragment: Onboarding3 = Onboarding3()
         var  arrayList: List<Fragment> =listOf(firstFragment, secondFragment, thirdFragment)
    }
}
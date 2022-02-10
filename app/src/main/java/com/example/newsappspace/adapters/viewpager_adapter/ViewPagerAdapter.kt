package com.example.newsappspace.adapters.viewpager_adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsappspace.fragments.onboarding.oboarding1.Onboarding1ExploreFragment
import com.example.newsappspace.fragments.onboarding.onboarding2.Onboarding2SearchFragment
import com.example.newsappspace.fragments.onboarding.onboarding3.Onboarding3SaveRelevantPostsFragment


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
         var a1ExploreFragment: Onboarding1ExploreFragment = Onboarding1ExploreFragment()
        var secondFragment:Onboarding2SearchFragment= Onboarding2SearchFragment()
        var thirdFragment: Onboarding3SaveRelevantPostsFragment = Onboarding3SaveRelevantPostsFragment()
         var  arrayList: List<Fragment> =listOf(a1ExploreFragment, secondFragment, thirdFragment)
    }
}
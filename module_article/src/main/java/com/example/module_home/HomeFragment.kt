package com.example.module_home

import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.TabLayoutMediator
import com.example.common_base.base.mvvm.BaseBindFragment
import com.example.common_base.constants.AConstance
import com.example.module_home.databinding.FragmentHomeBinding
import com.example.module_home.firstpage.FirstPageFragment
import com.example.module_home.search.SearchActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*

@Route(path = AConstance.FRAGMENT_URL_HOME)
class HomeFragment : BaseBindFragment<FragmentHomeBinding>() {

    private val fragments: MutableList<Fragment> = mutableListOf()
    private val titles: MutableList<String> = mutableListOf("首页", "分类")

     override fun initView(view: View?) {
        fragments.add(FirstPageFragment())
        fragments.add(FirstPageFragment())

        pager.adapter = object :
            FragmentStateAdapter(requireActivity().supportFragmentManager, lifecycle) {
            override fun getItemCount(): Int = fragments.size

            override fun createFragment(position: Int) = fragments[position]
        }

        TabLayoutMediator(tab_layout, pager, object : TabLayoutMediator.OnConfigureTabCallback {
            override fun onConfigureTab(tab: TabLayout.Tab?, position: Int) {
                tab?.text = titles[position]
            }
        }).attach()

        iv_search.setOnClickListener {
            startActivity(
                Intent(
                    requireActivity(),
                    SearchActivity::class.java
                )
            )
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_home
}


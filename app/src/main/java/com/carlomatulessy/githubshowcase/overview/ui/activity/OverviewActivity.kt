package com.carlomatulessy.githubshowcase.overview.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.carlomatulessy.githubshowcase.overview.ui.fragment.OverviewFragment

class OverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.let {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(OverviewFragment(), OverviewFragment::class.simpleName)
            }
        }
    }
}
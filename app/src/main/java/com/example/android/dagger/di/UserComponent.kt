package com.example.android.dagger.di

import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.settings.SettingsActivity
import dagger.Subcomponent

/**
 * Created by Brandon Quintanilla on Jul./19/2022
 */
@LoggedUserScope
@Subcomponent
interface UserComponent {

    @Subcomponent.Factory
    interface  Factory{
        fun create():UserComponent
    }
    fun inject(activity: MainActivity)
    fun inject(activity: SettingsActivity)
}
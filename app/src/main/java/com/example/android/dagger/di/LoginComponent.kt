package com.example.android.dagger.di

import com.example.android.dagger.login.LoginActivity
import dagger.Subcomponent

/**
 * Created by Brandon Quintanilla on Jul./19/2022
 */
@ActivityScope
@Subcomponent
interface LoginComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(activity: LoginActivity)
}
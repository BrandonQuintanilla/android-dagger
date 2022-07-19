package com.example.android.dagger.di

import dagger.Module

/**
 * Created by Brandon Quintanilla on Jul./19/2022
 */

//We have to make AppComponent know that RegistrationComponent
// is its subcomponent so that it can generate code for that.
// This module tells AppComponent which are its subcomponents
@Module(
    subcomponents = [
        RegistrationComponent::class,
        LoginComponent::class,
        UserComponent::class]
)
class AppSubcomponentsModule
package com.example.android.dagger.di

import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

/**
 * Created by Brandon Quintanilla on Jul./19/2022
 */
//subcomponents is a good practice to encapsulate different parts of your application from each other.

//We could call this scope @RegistrationScope but this is not a good practice.
//it should be named depending on the lifetime it has since annotations can be reused
@Subcomponent
@ActivityScope //No debemos repetir anotaciones como @Singleton con el Componente padre
interface RegistrationComponent {

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}
/*
Scoping rules:

- When a type is marked with a scope annotation, it can only be used
  by Components that are annotated with the same scope.
- When a Component is marked with a scope annotation, it can only provide
types with that annotation or types that have no annotation.
- A subcomponent cannot use a scope annotation used by one of its parent Components.

Components also involve subcomponents in this context.
* */
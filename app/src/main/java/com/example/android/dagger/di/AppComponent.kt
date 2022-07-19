package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.settings.SettingsActivity
import com.example.android.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

//@Component will make Dagger generate code with all the dependencies
// required to satisfy the parameters of the methods it exposes


//Use Scopes to have a unique instance of a type in a Component.
// If we annotate a Component with @Singleton,
// all the classes also annotated with @Singleton will be scoped to its lifetime.
@Singleton
// Definition of a Dagger component
@Component(modules = [StorageModule::class, AppSubcomponentsModule::class])
//In this way, AppComponent can access the information that StorageModule contains.
interface AppComponent {

    //This annotation is used to refer to the factory Dagger implementation
    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
        //@BindsInstance tells Dagger that it needs to add that instance in the graph
        //and whenever Context is required, provide that instance.
        //Context is already instantiated when injector graph is instantiated
    }

    //The name of the functions don't matter, what matters is the parameter type.
    // Classes that can be injected by this Component
//    fun inject(activity: MainActivity)
//    fun inject(fragment: EnterDetailsFragment)

    //We need to expose RegistrationComponent factory from the graph
    fun registrationComponent(): RegistrationComponent.Factory
    //El codigo que injectaria a RegistrationActivity ira en RegistrationComponent
//    fun inject(activity: RegistrationActivity)// RegistrationActivity requests injection.
//    fun inject(fragment: TermsAndConditionsFragment)

    fun loginCompononent(): LoginComponent.Factory


//    fun inject(activity: SettingsActivity)

    //Expose UserManager so that MainActivity and SettingsActivity
    // can access a particular instance of UserComponent
    fun userManager(): UserManager
}
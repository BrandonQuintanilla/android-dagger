package com.example.android.dagger.di

import javax.inject.Scope

/**
 * Created by Brandon Quintanilla on Jul./19/2022
 */

/*Cada anotacion hija de @Scope es un nuevo scope definido por dagger*/
@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class LoggedUserScope
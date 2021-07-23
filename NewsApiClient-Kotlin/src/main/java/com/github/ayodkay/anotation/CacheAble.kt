package com.github.ayodkay.anotation

/**
 * Created by Kayode Ayodele
 * =========================================
 * NewsApiClient-Kotlin
 * Copyright (C) 23/07/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Kayode Issac Ayodele
 * E-mail   : kayode@oamaru.com.br
 * Github   : github.com/ayodkay
 * LinkedIn : linkedin.com/in/kayode-ayodele/
 */


/**
 * Marks a request for caching
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class CacheAble
package com.juancacosta.kotlinweather.domain.commands

/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
interface Command<T>{
    fun execute():T
}
package com.juancacosta.kotlinweather.domain.commands

/**
 * Created by Juan C. Acosta on 5/19/2017.
 *
 */
public interface Command<T>{
    fun execute():T
}
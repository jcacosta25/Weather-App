package com.juancacosta.kotlinweather.extensions

/**
 * Created by jcacosta on 5/20/17.
 *
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()
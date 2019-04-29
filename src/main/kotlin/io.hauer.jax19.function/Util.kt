package io.hauer.jax19.function

import java.util.*


fun Any.printResult () = println( "Ergebnis ist $this")

fun <A, B, C> Pair<Optional<A>, Optional<B>>.map(f: (A, B) -> C) = this.first.flatMap { first -> second.map { second -> f(first, second) } }
fun <A, B, C> Pair<Optional<A>, Optional<B>>.flatMap(f: (A, B) -> Optional<C>) = this.first.flatMap { first -> second.flatMap { second -> f(first, second) } }

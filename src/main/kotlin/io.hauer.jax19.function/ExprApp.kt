package io.hauer.jax19.function

import java.util.*

val expression = Div(Const(12), Div(Const(36), Const(90)))

fun main() {
    eval(expression).printResult()
}

fun eval(expr: Expr): Optional<Int> = when (expr) {
    is Const -> Optional.of(expr.value)
    is Div -> {
        val ergLeft = eval(expr.left)
        if(ergLeft.isPresent){
            val ergRight = eval(expr.right)
            if(ergRight.isPresent){
                ergLeft.get() div ergRight.get()
            }
            else{
                Optional.empty()
            }
        }
        else{
            Optional.empty()
        }
    }
}

infix fun Int.div (other : Int) = if(other != 0) Optional.of(this / other) else Optional.empty()
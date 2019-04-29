package io.hauer.jax19.function

import java.util.*

val expression = Div(Const(12), Div(Const(36), Const(90)))

fun main() {
    eval(expression).printResult()
}

fun eval(expr: Expr): Optional<Int> = when (expr) {
    is Const -> Optional.of(expr.value)
    is Mul -> (eval(expr.left) to eval(expr.right)).map{ left, right -> left * right}
    is Div -> (eval(expr.left) to eval(expr.right)).flatMap { left, right -> left div right }
}

infix fun Int.div (other : Int) = if(other != 0) Optional.of(this / other) else Optional.empty()
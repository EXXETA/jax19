package io.hauer.jax19.function

val expression = Div(Const(12), Div(Const(36), Const(9)))

fun main() {
    eval(expression).printResult()
}

fun eval(expr: Expr): Int = when (expr) {
    is Const -> expr.value
    is Div -> eval(expr.left) / eval(expr.right)
}
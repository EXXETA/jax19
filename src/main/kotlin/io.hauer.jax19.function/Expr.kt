package io.hauer.jax19.function

sealed class Expr

class Const(val value: Int) : Expr()
class Mul(val left: Expr, val right: Expr) : Expr()
class Div(val left: Expr, val right: Expr) : Expr()
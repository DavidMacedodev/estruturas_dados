interface Empilhavel {

    fun empilhar(dado:Any?)
    fun atualizar(dado:Any?)
    fun desempilhar(): Any?
    fun espiar(): Any?
    fun imprimir(): String
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
}
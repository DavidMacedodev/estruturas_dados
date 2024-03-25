public interface Enfileiravel {

    fun espiar(): Any?
    fun enfileirar(dado: Any?)
    fun desenfileirar(): Any?
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun atualizar(dado: Any?)
    fun imprimir(): String
}
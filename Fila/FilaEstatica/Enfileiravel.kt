public interface Enfilieiravel {

    fun enfileirar(dado: Any?)
    fun atualizar(dado: Any?) 
    fun imprimir(): String
    fun espiar(): Any?
    fun desenfileirar(): Any?
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
}
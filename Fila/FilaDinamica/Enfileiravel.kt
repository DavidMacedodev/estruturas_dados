public interface Enfileiravel {

    fun enfileirar(dado:Any?) 
    fun desenfileirar(): Any?
    fun atualizar(dado:Any?)
    fun frente(): Any?
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}
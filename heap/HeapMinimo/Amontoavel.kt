public interface Amontoavel {

    fun extrair(): Long?
    fun inserir(dado: Long)
    fun atualizar(dado:Long)
    fun obter(): Long?
    fun imprimir(): String 
    fun estaCheio(): Boolean
    fun estaVazio(): Boolean
}
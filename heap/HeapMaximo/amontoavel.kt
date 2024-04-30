public interface Amontoavel {

    fun inserir(dado: Long) 	//insert	C
	fun extrair(): Long?		//extract	D
	fun obter(): Long?			//get		R
	fun atualizar(dado: Long)	//update	U
	
	fun imprimir(): String
	fun estaVazia(): Boolean
	fun estaCheia(): Boolean
}
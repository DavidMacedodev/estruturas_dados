public interface Listavel {

    fun inserir(posicao:Int, dado:Any?) // C
    fun apagar(posicao:Int):Any? //D
    fun anexar(dado:Any?)//C
    fun selecionar(posicao:Int):Any? // R
    fun selecionarTodos(): Array<Any?> // R
    fun atualizar(posicao:Int , dado:Any?) // U
  
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}
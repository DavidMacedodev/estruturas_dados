public interface Listavel {

    fun estaCheia():Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
    fun anexar(dado:Any?)
    fun apagar(posicao:Int): Any?
    fun apagarTodos(): Array<Any?>
    fun limpar()
    fun selecionar(posicao:Int): Any?
    fun selecionarTodos(): Array<Any?>
    fun atualizar(posicao:Int, dado:Any?)
    fun inserir(posicao:Int, dado: Any?)
    fun tamanho(): Int
}
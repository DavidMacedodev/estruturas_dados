class FilaEstaticaCircular: Enfileiravel {

    private var ponteiroInicio: Int
    private var ponteiroFim: Int
    private var quantidade: Int
    private var dados: Array< Any?>

    constructor(): this(10)

    constructor(tamanho: Int) {
        quantidade = 0
        ponteiroInicio  = 0
        ponteiroFim = -1
        dados = arrayOfNulls(tamanho)
    }

    
  override fun espiar(): Any?{
      var retorno: Any? = null
      if(!estaVazia()) {
        retorno = dados[ponteiroInicio]
      } else {
        println("Queue is empty!")
      }
      return retorno
  }
  override fun enfileirar(dado: Any?) {
         if(!estaCheia()){
            ponteiroFim++
            if (ponteiroFim == dados.size ) {
                ponteiroFim = 0;
            }
            quantidade++
            
            dados[ponteiroFim] = dado
         } else {
            println("Queue is full")
         }
  }
  override fun desenfileirar(): Any? {
       var retorno: Any? = null
       if(!estaVazia()) {
        retorno = dados[ponteiroInicio]
        ponteiroInicio++
        if(ponteiroInicio == dados.size) {
            ponteiroInicio = 0
            quantidade--
        }
       
       } else {
        println("Stack is empty")
       }
       return retorno
  }
  override fun estaCheia(): Boolean {
     return (quantidade == dados.size )
  }
  override fun estaVazia(): Boolean {
     return quantidade == 0
  }
  override fun atualizar(dado: Any?) {
    if(!estaVazia()){
        dados[ponteiroInicio] = dado
    }else {
        println("Stack is empty")
       }

  }
  override fun imprimir(): String {
    var resultado = "["
    var ponteiroAux = ponteiroInicio
    for (i in 0 .. quantidade-1) {
        if (i == quantidade-1)
            resultado += "${dados[ponteiroAux % dados.size]}"
        else
            resultado += "${dados[ponteiroAux % dados.size]},"

        ponteiroAux++				
    }
    return "$resultado]"
}
}
class FilaDinamica(private var tamanho:Int = 10): Enfileiravel {
    private var ponteiroInicio:NoDuplo? = null
    private var ponteiroFim:NoDuplo? = null
    private var quantidade = 0

    
     override fun enfileirar(dado:Any?)  {
        if(!estaCheia()) {
            var noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroFim
            if(!estaVazia())
            ponteiroFim?.proximo = noTemp
            else 
            ponteiroInicio = noTemp
            ponteiroFim = noTemp
            quantidade = quantidade.inc()
        }  else {
            println("Queue is full")
         }
    }
     override fun desenfileirar(): Any? {
        var dadoAux:Any? = null
        if(!estaVazia()) {
            dadoAux = ponteiroInicio?.dado
           ponteiroInicio = ponteiroInicio?.proximo 
           quantidade = quantidade.dec()
           if(!estaVazia())
           ponteiroInicio?.anterior = null
           else 
           ponteiroFim = null
        }  else {
            println("Queue is empty")
         }
         return dadoAux
      }
     override fun atualizar(dado:Any?) {
        if(!estaVazia()) {
            ponteiroInicio?.dado = dado
        } else {
            println("Queue is empty")
         }
     }
     override fun frente(): Any? {
        var dadoAux:Any? = null
        if(!estaVazia()) {
            dadoAux = ponteiroInicio?.dado
        }else {
            println("Queue is empty")
         }
         return dadoAux
     }
     override  fun estaCheia(): Boolean {
         return quantidade == tamanho
     }
     override  fun estaVazia(): Boolean {
        return quantidade == 0
     }
     override  fun imprimir(): String {
        var ponteiroAux = ponteiroInicio
        var resultado = "[" 
        for(i in 0 until quantidade) {
            resultado += "${ponteiroAux?.dado}"
            if(i != quantidade-1) 
            resultado += ","

            ponteiroAux = ponteiroAux?.proximo
        }
        return "$resultado]"

     }
}
public class ListaDinamica(private var tamanho:Int = 10): Listavel {

    private var ponteiroInicio: noDuplo? = null
    private var ponteiroFim: noDuplo? = null
    private var quantidade = 0

    override fun inserir(posicao:Int, dado:Any?) {
        if(!estaCheia()) {
            if(posicao >= 0 && posicao <= quantidade) {
                val noTemp = noDuplo(dado)

                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao)
                ponteiroAux = ponteiroAux?.proximo

                if(estaVazia()) {
                    ponteiroInicio = noTemp
                    ponteiroFim = noTemp
                } else {
                    val ponteiroProximo = ponteiroAux
                    val ponteiroAnterior = ponteiroAux?.anterior ?: ponteiroFim

                    if(ponteiroAnterior != null)
                    ponteiroAnterior.proximo = noTemp
                    else
                    ponteiroInicio = noTemp
                    if(ponteiroProximo != null)
                    ponteiroProximo.anterior = noTemp
                    else
                    ponteiroFim = noTemp

                    noTemp.anterior = ponteiroAnterior
                    noTemp.proximo = ponteiroProximo
                }
                quantidade = quantidade.inc()
                
            }else {
                println("Posicao invalida")
            }
        } else {
            println("Lista esta Vazia")
        }
        

    }
    override fun apagar(posicao:Int):Any?  {
        var dadoAux: Any? = null
        if(!estaVazia() ) {
            if(posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao)
                ponteiroAux = ponteiroAux?.proximo
               dadoAux = ponteiroAux?.dado
            
               val ponteiroAnterior = ponteiroAux?.anterior
               val ponteiroProximo = ponteiroAux?.proximo

               if(ponteiroAnterior != null) 
               ponteiroAnterior.proximo = ponteiroProximo
               else
               ponteiroInicio = ponteiroInicio?.proximo

               if(ponteiroProximo != null) 
               ponteiroProximo.anterior = ponteiroAnterior
               else
               ponteiroFim = ponteiroFim?.anterior
               quantidade = quantidade.dec()
            } else {
                println("Posicao invalida")
            }
        } else {
            println("Lista esta Vazia")
        }
        return dadoAux
        
    }
    override fun anexar(dado:Any?) {
        if(!estaCheia()) {
            val noTemp = noDuplo(dado)
            noTemp.anterior = ponteiroFim
            if(!estaVazia()) 
                ponteiroFim?.proximo = noTemp
           else
                ponteiroInicio = noTemp

                ponteiroFim = noTemp
                quantidade = quantidade.inc()
            
        } else {
            println("Lista esta Cheia")
        }
    }
    override fun selecionar(posicao:Int):Any?  {
        var dadoAux: Any? = null
        if(!estaVazia()) {
            if(posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao)
                ponteiroAux = ponteiroAux?.proximo
                dadoAux = ponteiroAux?.dado
            } else {
                println("Posicao invalida")
            }
        } else {
            println("Lista esta Vazia")
        }
        return dadoAux
    }
    override fun selecionarTodos(): Array<Any?>  {
        var dadoAux:Array<Any?> = arrayOfNulls(quantidade)
        if(!estaVazia()) {
            var ponteiroAux = ponteiroInicio
            for(i in 0 until quantidade) {
            
            dadoAux[i] = ponteiroAux?.dado
            ponteiroAux = ponteiroAux?.proximo
        }
    } else {
        println("Lista esta Vazia")
    }
    return dadoAux
    }
    override fun atualizar(posicao:Int , dado:Any?)  {
        if(!estaVazia()) {
            if(posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao)
                ponteiroAux = ponteiroAux?.proximo
                ponteiroAux?.dado = dado
            }else {
                    println("Posicao invalida")
                }
            } else {
                println("Lista esta Vazia")
            }
    }
  
    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }
    override fun estaVazia(): Boolean {
        return quantidade == 0
    }
    override fun imprimir(): String {
      var ponteiroAux = ponteiroInicio
      var resultado = "["
      for(i in 0 until quantidade) {
        resultado += ponteiroAux?.dado
        if(i != quantidade-1) 
        resultado += ","

        ponteiroAux = ponteiroAux?.proximo
      }
      return "$resultado]"
    } 
}
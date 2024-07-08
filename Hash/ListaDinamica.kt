public class ListaDinamica(private var tam:Int = 10): Listavel {

    private var ponteiroInicio: noDuplo? = null
    private var ponteiroFim: noDuplo? = null
    private var quantidade = 0


    override fun anexar(dado:Any?) {
        if(!estaCheia()) {
            var noTemp = noDuplo(dado)
            noTemp.anterior = ponteiroFim
            if(!estaVazia()) 
            ponteiroFim?.proximo = noTemp
            else 
            ponteiroInicio = noTemp
            ponteiroFim = noTemp
            quantidade = quantidade.inc()
        } else {
            println("Lista esta cheia")
        }
    }
    override fun apagar(posicao:Int): Any? {
        var dadoAux:Any? = null
        if(!estaVazia()) {
            if(posicao >= 0 && posicao < quantidade) {

                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao) 
                ponteiroAux = ponteiroAux?.proximo
               dadoAux = ponteiroAux?.dado
               
               var ponteiroProximo = ponteiroAux?.proximo
               var ponteiroAnterior =  ponteiroAux?.anterior
                
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
                println("posicao invalida")
            }
        } else {
            println("Lista esta vazia")
        }
        return dadoAux
    }
    override fun apagarTodos(): Array<Any?> {
        var dadoAux: Array<Any?> = selecionarTodos()
        limpar()
        return dadoAux
    }
    override fun limpar() {
        ponteiroFim =  null
        ponteiroInicio = null
        quantidade = 0
    }
    override fun selecionar(posicao:Int): Any? {
        var dadoAux: Any? = null
        if(!estaVazia()) {
            if(posicao >= 0 && posicao < quantidade) {

                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao) 
                ponteiroAux = ponteiroAux?.proximo
                dadoAux = ponteiroAux?.dado
            } else {
                println("posicao invalida")
            }
        } else {
            println("Lista esta vazia")
        }
        return dadoAux
    }
    override fun selecionarTodos(): Array<Any?> {
        var dadoAux: Array<Any?> = arrayOfNulls(tam)
        if(!estaVazia()) {
            var ponteiroAux = ponteiroInicio
            for(i in 0 until quantidade) {
                dadoAux[i] = ponteiroAux?.dado
                ponteiroAux = ponteiroAux?.proximo
            }
           
        }else {
            println("Lista esta vazia")
        }
        return dadoAux
    }
    override fun atualizar(posicao:Int, dado:Any?) {
        if(!estaVazia()) {
            if(posicao >= 0 && posicao < quantidade) {
                var ponteiroAux = ponteiroInicio
                for(i in 0 until posicao)      
                ponteiroAux = ponteiroAux?.proximo
                ponteiroAux?.dado = dado
             }   else {
                println("posicao invalida")
            }
             }else {
                println("Lista esta vazia")
            }
    }
    override fun inserir(posicao:Int, dado: Any?) {
        if(!estaCheia()) {
            if(posicao >= 0 && posicao <= quantidade) {
                  

                var ponteiroProximo = ponteiroInicio
                    var ponteiroAnterior: noDuplo? = null
                for(i in 0 until posicao)  {
                    ponteiroAnterior = ponteiroProximo
                    ponteiroProximo = ponteiroProximo?.proximo
                }
                    
                
                 var noTemp = noDuplo(dado)
                if(ponteiroAnterior != null) 
              ponteiroAnterior.proximo = noTemp
              else
              ponteiroInicio = noTemp

               if(ponteiroProximo != null) 
               ponteiroProximo.anterior = noTemp
               else
               ponteiroFim = noTemp

               noTemp.proximo = ponteiroProximo
               noTemp.anterior = ponteiroAnterior
               quantidade = quantidade.inc()
            } else {
                println("Indice invalido")
            }
        } else {
            println("lista esta cheia")
        }
    }
    override fun tamanho(): Int {
        return quantidade
    }
    override fun estaCheia():Boolean {
        return quantidade ==tam 
    }
    override fun estaVazia(): Boolean {
        return quantidade == 0
    }
    override  fun imprimir(): String {
        var ponteiroAuxiliar = ponteiroInicio
		var resultado = "["
		for (i in 0 until quantidade) {
			resultado += ponteiroAuxiliar?.dado
			if (i != quantidade-1)
				resultado += ","
			
			ponteiroAuxiliar = ponteiroAuxiliar?.proximo
		}
		return "$resultado]"
    }

}
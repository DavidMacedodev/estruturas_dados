class HeapMaximo(private var tam:Int = 10): Amontoavel {
    
     private var ponteiroFim = -1
     private var dados = LongArray(tam){0}

    override fun inserir(dado: Long) 	{
        if(!estaCheia()) {
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarCima(ponteiroFim)
        } else {
            println("Heap esta cheio")
        }
    }
    override fun extrair(): Long? {
        var dadoRaiz:Long? = null
        if(!estaVazia()) {
            dadoRaiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim = ponteiroFim.dec()
            ajustarBaixo(0)
        } else {
            println("Heap esta vazia")
        }
        return dadoRaiz
    }
    override fun obter(): Long? {
        var dadoRaiz:Long? = null
        if(!estaVazia()) {
           dadoRaiz = dados[0]
        } else {
            println("Heap esta vazia")
        }
        return dadoRaiz
    }			 
    override fun atualizar(dado: Long)	{
        if(!estaVazia()) {
            dados[0] = dado
            ajustarBaixo(0)
        } else {
            println("Heap esta vazia")
        }
    }
     
    override fun imprimir(): String {
      var resultado = "["
      for(i in 0 ..ponteiroFim) {
        resultado += "${dados[i]}"
        if(i !=ponteiroFim) 
        resultado += ","
      }
      return "$resultado]"
    }
    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }
    override fun estaCheia(): Boolean {
        return ponteiroFim == dados.size - 1
    }

    private fun trocar(i:Int, j:Int) {
        var temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    private fun indiceFilhoEsquerdo(pai:Int):Int {
       return 2* pai + 1
    }

    private fun indiceFilhoDireito(pai:Int):Int {
        return (2 * pai + 1) + 1
    }
    private fun indicePai(filho:Int): Int {
        return (filho -1) / 2
    }

    private fun ajustarCima(indice:Int) {
       var indiceAtual = indice
       while(indiceAtual != 0)  {
          val indicePai = indicePai(indiceAtual)
          if(dados[indicePai] < dados[indiceAtual]) {
            trocar(indiceAtual,indicePai)
            indiceAtual = indicePai
          } else {
            break
          }
       }
    }
    private fun ajustarBaixo(pai:Int) {
        var filhoDireito = indiceFilhoDireito(pai)
        val filhoEsquerdo = indiceFilhoEsquerdo(pai)
        var maior = pai

        if(filhoDireito <= ponteiroFim)
        if(dados[filhoDireito] < dados[maior])
        maior = filhoDireito

        if(filhoEsquerdo <= ponteiroFim) 
        if(dados[filhoEsquerdo] < dados[maior])
        maior = filhoEsquerdo

        if(maior != pai) {
            trocar(pai, maior)
            ajustarBaixo(maior)  
        }
     }

}
class HeapMinimo(private var tam: Int = 10): Amontoavel {
     
    private var dados = LongArray(tam){0}
    private var ponteiroFim = -1
    
    override fun extrair(): Long? {
      var dadoRaiz: Long? = null
      if(!estaVazio()) {
        dadoRaiz = dados[0]
        dados[0] = dados[ponteiroFim]
        ponteiroFim = ponteiroFim.dec()
        ajustarAbaixo(0)
      } else{
        println("Heap esta vazia")
      }
      return dadoRaiz
    }
    override fun inserir(dado: Long) {
     if(!estaCheio()) {
        ponteiroFim = ponteiroFim.inc()
        dados[ponteiroFim] = dado
        ajustarAcima(ponteiroFim)
     } else {
        println("Heap esta cheia")
     }
    }
    override fun atualizar(dado:Long) {
        if(!estaVazio()) {
            dados[0] = dado
            ajustarAbaixo(0)
        } else {
            println("Heap esta vazia")
        }
    }
    override fun obter(): Long? {
       var dadoRaiz: Long? = null
       if(!estaVazio()) {
        dadoRaiz = dados[0]
       } else {
        println("Heap esta vazia")
       }
       return dadoRaiz
    }
    override fun imprimir(): String  {
        var resultado = "["
        for(i in 0 .. ponteiroFim) {
        resultado += "${dados[i]}"
        if(i != ponteiroFim)
        resultado += ","

        }
         return "$resultado]"
    } 
    override fun estaCheio(): Boolean {
     return ponteiroFim == dados.size -1
    }
    override fun estaVazio(): Boolean {
        return ponteiroFim == -1
    }

    private fun trocar(i:Int, j:Int) {
        var temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    private fun indicePai(indiceFilho:Int):Int {
        return (indiceFilho -1) / 2
    }
    private fun indiceFilhoEsquerdo(indicePai:Int):Int {
        return (2 * indicePai + 1)
    }
    private fun indiceFilhoDireito(indicePai:Int):Int {
        return (2 * indicePai + 1) + 1
    } 
    private fun ajustarAcima(indice:Int) {
        var indiceAtual = indice
        while(indiceAtual != 0) {
            val indicePai = indicePai(indiceAtual)
            if(dados[indiceAtual] < dados[indicePai]) {
                trocar(indiceAtual,indicePai)
                indiceAtual = indicePai
            } else {
                break
            }
        }
    }

    private fun ajustarAbaixo(pai:Int) {
        var filhoEsquerdo = indiceFilhoEsquerdo(pai)
        val filhoDireito = indiceFilhoDireito(pai)
        var menor = pai

        if(filhoEsquerdo <= ponteiroFim)
        if(dados[menor] > dados[filhoEsquerdo]) 
        menor = filhoEsquerdo

        if(filhoDireito < ponteiroFim)
        if(dados[menor] > dados[filhoDireito])
         menor = filhoDireito

         if(menor != pai) {
            trocar(pai, menor)
            ajustarAbaixo(menor)
         }
    }


 }
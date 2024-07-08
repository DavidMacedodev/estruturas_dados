class HeapMaximoPaciente(private var tam: Int = 10): HeapingPaciente {

    private var dados:Array<Paciente?> = arrayOfNulls(tam)
    private var ponteiroFim = -1

    override fun atualizar(dado:Paciente) {
        if(!estaVazia()) {
          dados[0] = dado
          ajustarAbaixo(0)
        } else {
            println("Heap esta vazia")
        }
    }
    override fun extrair(): Paciente? {
      var dadoRaiz: Paciente? = null
      if(!estaVazia()) {
        dadoRaiz = dados[0]
        dados[0] = dados[ponteiroFim]
        ponteiroFim = ponteiroFim.dec()
        ajustarAbaixo(0)
      } else {
        println("Heap esta vazia")
      }
      return dadoRaiz
    }
    override fun inserir(dado:Paciente) {
        if(!estaCheia()) {
            ponteiroFim = ponteiroFim.inc()
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap esta vazia")
        }
    }
    override fun obter(): Paciente? {
        var dadoRaiz: Paciente? = null
      if(!estaVazia()) {
         dadoRaiz = dados[0]
      }else {
        println("Heap esta vazia")
      }
      return dadoRaiz
    }
    override fun imprimir(): String {
      var resultado = "\n["
      for(i in 0 .. ponteiroFim) {
        resultado += "${dados[i]}"
        if(i != ponteiroFim)
        resultado += ","

      }
      return "$resultado\n]"
    }
    override fun estaCheia(): Boolean {
        return ponteiroFim == dados.size -1
    }
    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }
    
    private fun trocar(i:Int, j:Int) {
        var temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }
    private fun filhoEsquerdo(pai:Int):Int {
        return 2 * pai + 1
    }

    private fun filhoDireito(pai:Int):Int {
        return (2 * pai + 1) + 1
    }

    private fun IndicePai(filho:Int):Int {
        return (filho -1) / 2
    }

    private fun ajustarAbaixo(pai:Int) {
     val filhoEsquerdo = filhoEsquerdo(pai)
     val filhoDireito = filhoDireito(pai)
     var maior = pai

     if(filhoDireito <= ponteiroFim)
     if(dados[filhoDireito]!!.prioridade > dados[maior]!!.prioridade)
     maior = filhoDireito

     if(filhoEsquerdo <= ponteiroFim)
     if(dados[filhoEsquerdo]!!.prioridade > dados[maior]!!.prioridade)
     maior = filhoEsquerdo


     if(maior != pai) {
        trocar(pai,maior)
        ajustarAbaixo(maior)
     }
  
    }

    private fun ajustarAcima(indice:Int ) {
        var indiceAtual = indice
        while(indiceAtual != 0) {
            var indicePai = IndicePai(indiceAtual)
            if(dados[indicePai]!!.prioridade < dados[indiceAtual]!!.prioridade) {
                trocar(indiceAtual, indicePai)
                indiceAtual = indicePai
            } else {
                break
            }
        
        }
        
        
    }
}
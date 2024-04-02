class FilaDinamica(private var tamanho:Int = 10):Enfileiravel {

    private var ponteiroInicio:NoDuplo? = null
    private var ponteiroFim:NoDuplo? = null
    private var quantidade:Int = 0
    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            var noTemp: NoDuplo? = NoDuplo(dado)
            noTemp?.anterior = ponteiroFim
            if (!estaVazia()) {
                ponteiroFim?.proximo = noTemp
            } else {
                ponteiroInicio = noTemp
            }

            ponteiroFim = noTemp
            quantidade++
        } else {
            println("Queue is full")
        }
    }



    override fun desenfileirar(): Any? {
            var retorno: Any? = null
            if (!estaVazia()) {
                retorno = ponteiroInicio?.dado
                ponteiroInicio = ponteiroInicio?.proximo
                if (ponteiroInicio == null) {
                    ponteiroFim = null
                } else {
                    ponteiroInicio?.anterior = null
                }
                quantidade--
            } else {
                println("Queue is empty")
            }
            return retorno
        }


    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            ponteiroInicio?.dado = dado
        } else {
            println("Fila Vazia!")
        }
    }

    override fun frente(): Any? {
        var retorno: Any? = null
        if(!estaVazia()) {
            retorno = ponteiroInicio?.dado
        } else {
            println("Queue is empty")
        }
        return retorno
    }

    override fun estaCheia(): Boolean {
     return  quantidade == tamanho

    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
      var resultado = "["
        var ponteiroAux:NoDuplo? = ponteiroInicio
        for(i in 0 until quantidade) {
            if(i == quantidade-1){
                resultado += "${ponteiroAux?.dado}"
            }
            else {
                resultado += "${ponteiroAux?.dado}, \n"
            }
           ponteiroAux = ponteiroAux?.proximo
        }
        return (resultado + "]")
    }
}
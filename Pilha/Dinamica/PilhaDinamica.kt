class PilhaDinamica(private val tamanho:Int = 10): Empilhavel {
    private var ponteiroTopo: NoDuplo? = NoDuplo()
    private var quantidade:Int = 0
    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            var noTemp: NoDuplo? = NoDuplo(dado)
            noTemp?.anterior = ponteiroTopo
            if (!estaVazia()) {
                ponteiroTopo?.proximo = noTemp

            }
            ponteiroTopo = noTemp
            quantidade++
        } else {
            println("Pilha cheia")
        }
    }

    override fun atualizar(dado: Any?) {

        if(!estaVazia()) {

             ponteiroTopo?.dado = dado
        } else {
            println("Stack is empty")
        }

    }

    override fun desempilhar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            quantidade--
            if (!estaVazia()) {
                ponteiroTopo?.proximo = null
            }
        } else {
            println("Pilha Vazia!")
        }
        return dadoTopo
    }

    override fun espiar(): Any? {
        var retorno: Any? = null
        if(!estaVazia()) {

            retorno = ponteiroTopo?.dado
        } else {
            println("Stack is empty")
        }
        return retorno
    }


    override fun imprimir(): String {
        var ponteiroAuxiliar: NoDuplo? = ponteiroTopo
        var resultado : String = "["
        for (i in 0 until quantidade) {
            if (i == quantidade-1)
                resultado += "${ponteiroAuxiliar?.dado}"
            else
                resultado += "${ponteiroAuxiliar?.dado},\n"

            ponteiroAuxiliar = ponteiroAuxiliar?.anterior
        }
        return (resultado + "]")
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
       return quantidade == 0
    }


}
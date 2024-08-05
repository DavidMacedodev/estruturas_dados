class AVLTree : Arborizavel {
    private var raiz: NoTriplo? = null

    override fun getRaiz(): NoTriplo? = raiz

    override fun limpar() {
        raiz = null
    }

    override fun inserir(dado: Any?) {
        raiz = inserirRec(raiz, dado)
    }

    private fun inserirRec(nodo: NoTriplo?, dado: Any?): NoTriplo? {
        if (nodo == null) {
            return NoTriplo(dado)
        }

        if ((dado as Int) < (nodo.dado as Int)) {
            nodo.esquerda = inserirRec(nodo.esquerda, dado)
        } else if ((dado as Int) > (nodo.dado as Int)) {
            nodo.direita = inserirRec(nodo.direita, dado)
        } else {
            return nodo // Não permite duplicatas
        }

        return balancear(nodo)
    }

    private fun balancear(nodo: NoTriplo): NoTriplo {
        val fatorBalanceamento = altura(nodo.esquerda) - altura(nodo.direita)

        return when {
            fatorBalanceamento > 1 && (altura(nodo.esquerda?.esquerda) ?: 0) >= (altura(nodo.esquerda?.direita) ?: 0) -> rotacionarDireita(nodo)
            fatorBalanceamento > 1 && (altura(nodo.esquerda?.esquerda) ?: 0) < (altura(nodo.esquerda?.direita) ?: 0) -> {
                nodo.esquerda = rotacionarEsquerda(nodo.esquerda!!)
                rotacionarDireita(nodo)
            }
            fatorBalanceamento < -1 && (altura(nodo.direita?.direita) ?: 0) >= (altura(nodo.direita?.esquerda) ?: 0) -> rotacionarEsquerda(nodo)
            fatorBalanceamento < -1 && (altura(nodo.direita?.direita) ?: 0) < (altura(nodo.direita?.esquerda) ?: 0) -> {
                nodo.direita = rotacionarDireita(nodo.direita!!)
                rotacionarEsquerda(nodo)
            }
            else -> nodo
        }
    }

    private fun rotacionarEsquerda(nodo: NoTriplo): NoTriplo {
        val novaRaiz = nodo.direita!!
        nodo.direita = novaRaiz.esquerda
        novaRaiz.esquerda = nodo
        return novaRaiz
    }

    private fun rotacionarDireita(nodo: NoTriplo): NoTriplo {
        val novaRaiz = nodo.esquerda!!
        nodo.esquerda = novaRaiz.direita
        novaRaiz.direita = nodo
        return novaRaiz
    }

    private fun altura(nodo: NoTriplo?): Int {
        return nodo?.let { maxOf(altura(nodo.esquerda), altura(nodo.direita)) + 1 } ?: 0
    }

    override fun apagar(dado: Any?): Boolean {
        raiz = apagarRec(raiz, dado)
        return raiz != null
    }

    private fun apagarRec(nodo: NoTriplo?, dado: Any?): NoTriplo? {
        if (nodo == null) {
            return null
        }

        when {
            (dado as Int) < (nodo.dado as Int) -> nodo.esquerda = apagarRec(nodo.esquerda, dado)
            (dado as Int) > (nodo.dado as Int) -> nodo.direita = apagarRec(nodo.direita, dado)
            else -> {
                return when {
                    nodo.esquerda == null -> nodo.direita
                    nodo.direita == null -> nodo.esquerda
                    else -> {
                        val sucessor = obterSucessor(nodo.direita!!)
                        nodo.dado = sucessor.dado
                        nodo.direita = apagarRec(nodo.direita, sucessor.dado)
                        nodo
                    }
                }
            }
        }
        return balancear(nodo)
    }

    private fun obterSucessor(nodo: NoTriplo): NoTriplo {
        var atual = nodo
        while (atual.esquerda != null) {
            atual = atual.esquerda!!
        }
        return atual
    }

    override fun buscar(dado: Any): NoTriplo? {
        return buscarRec(raiz, dado)
    }

    private fun buscarRec(nodo: NoTriplo?, dado: Any): NoTriplo? {
        if (nodo == null) {
            return null
        }

        return when {
            (dado as Int) < (nodo.dado as Int) -> buscarRec(nodo.esquerda, dado)
            (dado as Int) > (nodo.dado as Int) -> buscarRec(nodo.direita, dado)
            else -> nodo
        }
    }

    override fun existe(dado: Any?): Boolean {
        return buscar(dado!!) != null
    }

    override fun imprimirPreOrdem(): String {
        return formataSaida(imprimirPreOrdemRec(raiz))
    }

    override fun imprimirEmOrdem(): String {
        return formataSaida(imprimirEmOrdemRec(raiz))
    }

    override fun imprimirPosOrdem(): String {
        return formataSaida(imprimirPosOrdemRec(raiz))
    }

    private fun imprimirPreOrdemRec(nodo: NoTriplo?): String {
        return nodo?.let { "${it.dado} ${imprimirPreOrdemRec(it.esquerda)} ${imprimirPreOrdemRec(it.direita)}" } ?: ""
    }

    private fun imprimirEmOrdemRec(nodo: NoTriplo?): String {
        return nodo?.let { "${imprimirEmOrdemRec(it.esquerda)} ${it.dado} ${imprimirEmOrdemRec(it.direita)}" } ?: ""
    }

    private fun imprimirPosOrdemRec(nodo: NoTriplo?): String {
        return nodo?.let { "${imprimirPosOrdemRec(it.esquerda)} ${imprimirPosOrdemRec(it.direita)} ${it.dado}" } ?: ""
    }

    private fun formataSaida(msg: String): String {
        var resultado: String
        var mensagem = msg
        do {
            resultado = mensagem
            mensagem = mensagem.replace("  ", " ")
        } while (mensagem != resultado)
        mensagem = mensagem.trim()
        mensagem = mensagem.replace(" ", ",")
        return "[$mensagem]"
    }
}

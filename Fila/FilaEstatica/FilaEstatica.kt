class FilaEstatica: Enfilieiravel {
    private var ponteiroInicio: Int
    private var ponteiroFim: Int
    private var dados: Array<Any?>

    constructor(): this(10)

    constructor(tamanho: Int) {
        ponteiroInicio = 0
        ponteiroFim = -1
        dados = arrayOfNulls(tamanho)
    }

    override fun enfileirar(dado: Any?) {
        if(!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
        } else {
            println("queue is fulll")
        }
    }

    override fun desenfileirar(): Any? {
        var retorno: Any? = null
        if(!estaVazia()) {
            retorno = dados[ponteiroInicio]
            ponteiroInicio++
        } else {
            println("queue is empty")
        }
        return retorno
    }

    override fun espiar(): Any? {
        var retorno: Any? = null
        if(!estaVazia()) {
            retorno = dados[ponteiroInicio]
        }else {
            println("queue is empty")
        }
        return retorno
    }

    override fun estaCheia(): Boolean {
        return (ponteiroFim == dados.size -1)
    }
    override fun estaVazia(): Boolean {
        return (ponteiroInicio == ponteiroFim + 1)
    }
    override fun atualizar(dado: Any?) {
        if(!estaVazia()) {
           dados[ponteiroFim] = dado
        } else {
            println("Stack is empty")
        }
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in ponteiroInicio..ponteiroFim ) {
            if(i == ponteiroFim)
            resultado += "${dados[i]}"
            else 
            resultado += "${dados[i]},"
        }
        return "$resultado]"
    }
}
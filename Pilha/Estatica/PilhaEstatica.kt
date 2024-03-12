package Pilhas.Estatica

fun main(){
    var pilha = PilhaEstatica(20)

    pilha.empilhar("Instituto")

    pilha.empilhar("Federal")

    println("Topo: ${pilha.topo()}")

    pilha.empilhar("de")

    pilha.empilhar("Educação")

    pilha.empilhar("Ciência")

    var dadoQualquer = pilha.desempilhar()

    pilha.empilhar("e")

    pilha.empilhar("tecnologia")

    pilha.empilhar(dadoQualquer)

    println("Dados: ${pilha.imprimir()}")
}
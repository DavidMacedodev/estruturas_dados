fun main() {
    var fila: Enfilieiravel = FilaEstatica()
    fila.enfileirar("A");
    println("Frente: ${fila.espiar()}")	
    fila.enfileirar("B")
    fila.enfileirar("C")
    fila.enfileirar("D")
    fila.desenfileirar()
    fila.enfileirar("E")
    val conteudo = fila.desenfileirar()
    fila.enfileirar("F")
    println("Frente: ${fila.espiar()}")
    println("Frente: ${fila.espiar()}")	
    fila.enfileirar("G");
    fila.enfileirar(conteudo)
    fila.enfileirar("I")
    fila.enfileirar("J")
    fila.enfileirar("K")				
    println("Fila=${fila.imprimir()}")
}
class MergeSort(private var lista:ListaDinamica): Ordenavel {


    override fun imprimir() {
      println(lista.imprimir())
    }
  
    private fun trocar(no1: NoDuplo, no2:NoDuplo) {
      var noTemp = no1.dado
      no1.dado = no2.dado
      no2.dado = noTemp
    }
  
  
     override fun ordenar() {
       mergesort(lista)
     }
  
   fun mergesort(lista: ListaDinamica) {
      val inicio = lista.ponteiroInicio
     if(inicio == null || inicio.proximo == null) {
       return
     }
  
     var (esquerda,direita) = dividirLista(lista)
  
     mergesort(esquerda)
     mergesort(direita)
  
     lista.ponteiroInicio = mesclar(esquerda.ponteiroInicio,direita.ponteiroInicio)
   } 
  
   fun mesclar(esq: NoDuplo?, dir: NoDuplo?): NoDuplo? {
     if(esq == null) return dir
     if(dir == null) return esq
  
     var resultado: NoDuplo? = null  
      if(esq.dado as Int <= dir.dado as Int) {
        resultado = esq
        resultado.proximo = mesclar(esq.proximo,dir)
        resultado.proximo?.anterior = resultado
      } else {
        resultado = dir
        resultado.proximo = mesclar(esq, dir.proximo)
         resultado.proximo?.anterior = resultado
      }
      return resultado
   }
     
    private fun dividirLista(lista: ListaDinamica): Pair<ListaDinamica, ListaDinamica> {
        val inicio = lista.ponteiroInicio ?: return Pair(ListaDinamica(), ListaDinamica())
  
        var lento = inicio
        var rapido = inicio.proximo
  
        // O rápido se move duas vezes mais rápido que o lento
        while (rapido != null) {
            rapido = rapido.proximo
            if (rapido != null) {
                lento = lento.proximo
                rapido = rapido.proximo
            }
        }
  
        // lento é o nó do meio
        val direita = ListaDinamica()
        direita.ponteiroInicio = lento?.proximo
        lento?.proximo = null  // Separar a lista na metade
  
        val esquerda = ListaDinamica()
        esquerda.ponteiroInicio = inicio
  
        return Pair(esquerda, direita)
    }
  }
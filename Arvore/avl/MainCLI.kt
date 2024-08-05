fun main() {
    // Testar entrada nesta ordem: 4 2 6 1 3 5 7
    // Pre Ordem: [4,2,1,3,6,5,7] 
    // Em Ordem: [1,2,3,4,5,6,7]
    // Pos Ordem: [1,3,2,5,7,6,4]
    val arvore: Arborizavel = AVLTree()
    do {
        exibirMenu()
        val opcao = readLine()!!.toInt()
        when(opcao) {
            0 -> println("Saindo da Árvore AVL. Até mais!")
            1 -> {
                print("Digite o valor: ")
                val valor = readLine()!!.toInt()
                arvore.inserir(valor)
            }
            2 -> {
                print("Digite o valor: ")
                val valor = readLine()!!.toInt()            
                arvore.apagar(valor)
            }
            3 -> {
                print("Digite o valor: ")
                val valor = readLine()!!.toInt()
                println(arvore.existe(valor))
            }
            4 -> {
                exibirMenuImprimir()
                val opcaoImprimir = readLine()!!.toInt()
                when(opcaoImprimir) {
                    1 -> println("\nPre-Ordem: ${arvore.imprimirPreOrdem()}\n")
                    2 -> println("\nEm-Ordem: ${arvore.imprimirEmOrdem()}\n")                        
                    3 -> println("\nPos-Ordem: ${arvore.imprimirPosOrdem()}\n")
                    else -> println("Opção inválida.")
                }
            }
            5 -> {                    
                arvore.limpar()
                println("Árvore limpa!")
            }
            else -> {
                print("Opção inválida. ")
                println("Tente novamente.")
            }
        }
    } while

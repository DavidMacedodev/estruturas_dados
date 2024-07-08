public interface HeapingPaciente {

    fun atualizar(dado:Paciente)
    fun extrair(): Paciente?
    fun inserir(dado:Paciente)
    fun obter(): Paciente?
    fun imprimir(): String
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    
}
//criação pessoa
export interface Todo {
    id?: String, //? é para que o dado na tabela possa ser opcional
    titulo: String,
    descricao?: String,
    dataParaFinalizar: any,
    finalizado: Boolean
}
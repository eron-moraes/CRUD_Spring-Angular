// Interface genérica para uma entidade com uma chave única.
interface Identifiable<T> {
  id: T; // A chave única da entidade
}

// Classe genérica representando uma entidade básica.
class BaseEntity<T> implements Identifiable<T> {
  constructor(public id: T, public createdAt: Date) {}
}

// Interface genérica para um repositório com operações CRUD básicas.
interface Repository<T extends Identifiable<any>> {
  findById(id: T['id']): T | undefined; // Procura uma entidade pelo ID
  findAll(): T[]; // Retorna todas as entidades do repositório
  save(entity: T): void; // Salva uma nova entidade no repositório
  update(id: T['id'], entity: T): void; // Atualiza uma entidade existente no repositório
  delete(id: T['id']): void; // Remove uma entidade do repositório
}

// Classe concreta que implementa o repositório genérico para a entidade BaseEntity.
class BaseEntityRepository implements Repository<BaseEntity<number>> {
  private entities: BaseEntity<number>[] = []; // Array para armazenar as entidades

  // Procura uma entidade pelo ID no repositório e retorna a entidade, ou undefined se não encontrar.
  findById(id: number): BaseEntity<number> | undefined {
    return this.entities.find((entity) => entity.id === id);
  }

  // Retorna todas as entidades presentes no repositório.
  findAll(): BaseEntity<number>[] {
    return this.entities;
  }

  // Salva uma nova entidade no repositório adicionando-a ao array.
  save(entity: BaseEntity<number>): void {
    this.entities.push(entity);
  }

  // Atualiza uma entidade existente no repositório, substituindo-a pela entidade atualizada.
  update(id: number, updatedEntity: BaseEntity<number>): void {
    const index = this.entities.findIndex((entity) => entity.id === id);
    if (index !== -1) {
      this.entities[index] = updatedEntity;
    }
  }

  // Remove uma entidade do repositório com base no ID.
  delete(id: number): void {
    this.entities = this.entities.filter((entity) => entity.id !== id);
  }
}

// Exemplo de uso do código acima:
const repository = new BaseEntityRepository();

// Criar duas novas entidades e salvá-las no repositório.
const entity1 = new BaseEntity(1, new Date('2023-01-01'));
const entity2 = new BaseEntity(2, new Date('2023-02-15'));
repository.save(entity1);
repository.save(entity2);

// Procurar e imprimir a entidade com ID 1.
const foundEntity = repository.findById(1);
console.log('Encontrado:', foundEntity);

// Imprimir todas as entidades do repositório.
const allEntities = repository.findAll();
console.log('Todas as entidades:', allEntities);

// Atualizar a segunda entidade e imprimir todas as entidades após a atualização.
entity2.createdAt = new Date('2023-03-20');
repository.update(2, entity2);
console.log('Entidades após atualização:', repository.findAll());

// Remover a primeira entidade do repositório e imprimir todas as entidades após a remoção.
repository.delete(1);
console.log('Entidades após deletar a entidade com ID 1:', repository.findAll());

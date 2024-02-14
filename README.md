# perinity-tasklist

Tasklist (Teste para Perinity)

## API de gerenciamento de tarefas com criação de Departamentos, Pessoas e Tarefas

## Tecnologias
    - Java
    - Spring
    - JPA
    - Hibernate
    - Docker
    - Postgresql

## Executando o projeto

1. Executar o comando `docker-compose up -d` para iniciar o conteiner do banco de dados Postgres
2. Iniciar a aplicação com o comando `mvn spring-boot:run`;
3. A aplicação estará rodando no endereço `localhost:8082`

## Rotas da API

Path | Método |  Descrição
------------------------------------ |--------| -----
/departamentos | POST | Adiciona um Departamento
/pessoas | POST   | Adicionar uma Pessoa
/pessoas/:id | PUT    | Alterar uma Pessoa a partir de sua ID
/pessoas/:id | DELETE | Remover uma Pessoa a parti de sua ID
/tarefas | POST   |  Adicionar uma Tarefa
/tarefas/alocar/:id | PUT    | Finalizar a Tarefa
/pessoas | GET    | Listar Pessoas trazendo nome, Departamento, total horas gastas nas Tarefas
/pessoas/gastos?nome=:nome&dataInicial=:dataInicial&dataFinal=:dataFinal | GET    | Buscar Pessoas por nome e período, retorna média de horas gastas por Tarefa
/tarefas/pendentes | GET    | Listar 3 Tarefas que estejam sem pessoa alocada com os prazos mais antigos
/departamentos | GET    | Listar Departamento e quantidade de Pessoas e Tarefas

## API

### POST /departamentos
```json
{
  "titulo": "Contabilidade"
}
```

### POST /pessoas

request.body
```json
{
  "nome": "Funcionario Teste",
  "idDepartamento": 1
}
```

### PUT /pessoas/:id

request.body
```json
{
  "nome": "Funcionario"
}
```

### DELETE /pessoas/:id

response.body
`Pessoa com ID {id} deletada`

### POST /tarefas

request.body

```json
{
  "titulo": "Tarefa 1",
  "descricao": "Tarefa 1",
  "prazo": "20/02/2024",
  "duracao": 2,
  "idDepartamento": 1,
  "idPessoa": 1
}
```

### PUT /tarefas/alocar/:id

request.body
```json
{
  "idPessoa": 1
}
```

### PUT /tarefas/finalizar/:id

response.body: `TarefaEntity`

### GET /pessoas

response.body
```json
[
  {
    "nome": "Nome",
    "departamento": "Departamento",
    "horasGastas": 1
  },
  {
    "nome": "Outro Nome",
    "departamento": "Outro Departamento",
    "horasGastas": 2
  }
]
```

### GET /pessoas/gastos?nome=:nome&dataInicial=:dataInicial&dataFinal=:dataFinal

response.body
```json
{
  "nome": "Nome",
  "mediaPorTarefa": 2.375
}
```

### GET /tarefas/pendentes

response.body
```json
[
  {
    "id": 1,
    "titulo": "Tarefa 1",
    "descricao": "Tarefa 1",
    "prazo": "2024-02-13",
    "duracao": 2,
    "finalizado": false,
    "idDepartamento": 1,
    "idPessoa": 1
  }
]
```

### GET /departamentos

response.body
```json
[
  {
    "id": 1,
    "titulo": "Informatica",
    "qtdeTarefas": 9,
    "qtdePessoas": 2
  },
  {
    "id": 2,
    "titulo": "Qualidade",
    "qtdeTarefas": 2,
    "qtdePessoas": 1
  }
]
```

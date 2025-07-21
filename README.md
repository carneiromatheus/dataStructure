# Estruturas de Dados

Este projeto implementa estruturas de dados básicas em Java, incluindo uma lista dinâmica (`ArrayList`), uma fila (`Queue`) e uma pilha (`Stack`).

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

```
src/
    dev/
        matheuscarneiro/
            App.java
            structure/
                list/
                    ArrayList.java
                    Queue.java
                    Stack.java
lib/
```

- **`src/`**: Contém o código-fonte do projeto.
  - **`App.java`**: Classe principal.
  - **`structure/list/`**: Contém as implementações das estruturas de dados.
    - **`ArrayList.java`**: Implementação de uma lista dinâmica genérica.
    - **`Queue.java`**: Implementação de uma fila genérica baseada em `ArrayList`.
    - **`Stack.java`**: Implementação de uma pilha genérica baseada em `ArrayList`.
- **`lib/`**: Diretório reservado para dependências externas (atualmente vazio).

## Estruturas de Dados Implementadas

### ArrayList

Uma implementação genérica de lista dinâmica com as seguintes funcionalidades:
- Adicionar elementos no final ou em uma posição específica.
- Remover elementos por índice.
- Obter ou modificar elementos por índice.
- Verificar se a lista contém um elemento.
- Limpar todos os elementos.
- Verificar se está vazia e obter o tamanho.

### Queue

Uma implementação genérica de fila baseada em `ArrayList` com as seguintes funcionalidades:
- Inserir elementos no final da fila (`enqueue`).
- Remover e retornar o elemento no início da fila (`dequeue`).
- Visualizar o elemento no início da fila sem removê-lo (`peek`).
- Verificar se a fila está vazia e obter o tamanho.

### Stack

Uma implementação genérica de pilha baseada em `ArrayList` com as seguintes funcionalidades:
- Inserir elementos no topo da pilha (`push`).
- Remover e retornar o elemento no topo da pilha (`pop`).
- Visualizar o elemento no topo da pilha sem removê-lo (`peek`).
- Verificar se a pilha está vazia e obter o tamanho.

## Como Executar

1. Certifique-se de ter o Java instalado em sua máquina.
2. Compile os arquivos Java:
   ```bash
   javac -d bin src/dev/matheuscarneiro/**/*.java
   ```
3. Execute a classe principal:
   ```bash
   java -cp bin dev.matheuscarneiro.App
   ```

## Exemplo de Saída

Ao executar o programa principal (`App.java`), você verá uma saída semelhante a esta:

```
App: - I'm healthy! \o/
```

## Contribuição

Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias ou correções.

## Licença

Este projeto é de uso livre e aberto. Sinta-se à vontade para utilizá-lo e modificá-lo conforme necessário.

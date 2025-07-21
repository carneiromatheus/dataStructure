# Estruturas de Dados

Este projeto implementa estruturas de dados básicas em Java, incluindo implementações baseadas em array e listas encadeadas.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

```
src/
    dev/
        matheuscarneiro/
            App.java
            structure/
                list/
                    linear/
                        ArrayList.java
                        Queue.java
                        Stack.java
                    linked/
                        Node.java
                        SinglyLinkedList.java
                        DoublyLinkedList.java
                        CircularSinglyLinkedList.java
                        CircularDoublyLinkedList.java
                        Queue.java
                        Stack.java
lib/
```

- **`src/`**: Contém o código-fonte do projeto.
  - **`App.java`**: Classe principal que demonstra o funcionamento básico do projeto.
  - **`structure/list/`**: Contém as implementações das estruturas de dados organizadas por categoria.
    - **`linear/`**: Estruturas de dados lineares baseadas em arrays.
      - **`ArrayList.java`**: Implementação de uma lista dinâmica genérica.
      - **`Queue.java`**: Implementação de uma fila genérica baseada em `ArrayList`.
      - **`Stack.java`**: Implementação de uma pilha genérica baseada em `ArrayList`.
    - **`linked/`**: Estruturas de dados baseadas em nós ligados.
      - **`Node.java`**: Classe auxiliar que representa um nó para listas ligadas.
      - **`SinglyLinkedList.java`**: Implementação de uma lista simplesmente ligada genérica.
      - **`DoublyLinkedList.java`**: Implementação de uma lista duplamente ligada genérica.
      - **`CircularSinglyLinkedList.java`**: Implementação de uma lista circular simplesmente ligada genérica.
      - **`CircularDoublyLinkedList.java`**: Implementação de uma lista circular duplamente ligada genérica.
      - **`Queue.java`**: Implementação de uma fila genérica baseada em lista duplamente ligada.
      - **`Stack.java`**: Implementação de uma pilha genérica baseada em lista duplamente ligada.
- **`lib/`**: Diretório reservado para dependências externas (atualmente vazio).

## Estruturas de Dados Implementadas

### Estruturas Lineares (Baseadas em Array)

#### ArrayList

Uma implementação genérica de lista dinâmica com as seguintes funcionalidades:
- Adicionar elementos no final ou em uma posição específica.
- Remover elementos por índice.
- Obter ou modificar elementos por índice.
- Verificar se a lista contém um elemento.
- Limpar todos os elementos.
- Verificar se está vazia e obter o tamanho.

#### Queue

Uma implementação genérica de fila baseada em `ArrayList` com as seguintes funcionalidades:
- Inserir elementos no final da fila (`enqueue`).
- Remover e retornar o elemento no início da fila (`dequeue`).
- Visualizar o elemento no início da fila sem removê-lo (`peek`).
- Verificar se a fila está vazia e obter o tamanho.

#### Stack

Uma implementação genérica de pilha baseada em `ArrayList` com as seguintes funcionalidades:
- Inserir elementos no topo da pilha (`push`).
- Remover e retornar o elemento no topo da pilha (`pop`).
- Visualizar o elemento no topo da pilha sem removê-lo (`peek`).
- Verificar se a pilha está vazia e obter o tamanho.

### Estruturas Ligadas (Baseadas em Nós)

#### Node

Classe auxiliar que representa um nó individual para estruturas de dados ligadas:
- Armazena dados genéricos e referências para o próximo e anterior nó (prev/next).
- Validação para garantir que os dados não sejam nulos.
- Suporte tanto para listas simplesmente quanto duplamente ligadas.

#### SinglyLinkedList

Uma implementação genérica de lista simplesmente ligada com as seguintes funcionalidades:
- Adicionar elementos no início (`addFirst`), final (`addLast`) ou em posição específica (`add`).
- Remover elementos do início (`removeFirst`), final (`removeLast`) ou por índice (`remove`).
- Obter elementos por índice (`get`).
- Verificar se está vazia e obter o tamanho.
- Gerenciamento automático dos ponteiros head e tail.

#### DoublyLinkedList

Uma implementação genérica de lista duplamente ligada com as seguintes funcionalidades:
- Adicionar elementos no início (`addFirst`), final (`addLast`) ou em posição específica (`add`).
- Remover elementos do início (`removeFirst`), final (`removeLast`) ou por índice (`remove`).
- Obter elementos por índice (`get`).
- Verificar se está vazia e obter o tamanho.
- Navegação bidirecional com ponteiros anterior e próximo.
- Gerenciamento automático dos ponteiros head e tail.

#### CircularSinglyLinkedList

Uma implementação genérica de lista circular simplesmente ligada com as seguintes funcionalidades:
- Adicionar elementos no início (`addFirst`), final (`addLast`) ou em posição específica (`add`).
- Remover elementos do início (`removeFirst`), final (`removeLast`) ou por índice (`remove`).
- Obter elementos por índice (`get`).
- Verificar se está vazia e obter o tamanho.
- Estrutura circular onde o último nó aponta para o primeiro.
- Gerenciamento automático dos ponteiros head e tail.

#### CircularDoublyLinkedList

Uma implementação genérica de lista circular duplamente ligada com as seguintes funcionalidades:
- Adicionar elementos no início (`addFirst`), final (`addLast`) ou em posição específica (`add`).
- Remover elementos do início (`removeFirst`), final (`removeLast`) ou por índice (`remove`).
- Obter elementos por índice (`get`).
- Verificar se está vazia e obter o tamanho.
- Navegação bidirecional com ponteiros anterior e próximo.
- Estrutura circular onde head e tail estão conectados bidirecionalmente.
- Otimização de busca baseada na proximidade do índice ao início ou fim.
- Gerenciamento automático dos ponteiros head e tail.

#### Queue (Baseada em Lista Ligada)

Uma implementação genérica de fila baseada em `DoublyLinkedList` com as seguintes funcionalidades:
- Inserir elementos no final da fila (`enqueue`).
- Remover e retornar o elemento no início da fila (`dequeue`).
- Visualizar o elemento no início da fila sem removê-lo (`peek`).
- Verificar se a fila está vazia e obter o tamanho.
- Operações eficientes de inserção e remoção em O(1).

#### Stack (Baseada em Lista Ligada)

Uma implementação genérica de pilha baseada em `DoublyLinkedList` com as seguintes funcionalidades:
- Inserir elementos no topo da pilha (`push`).
- Remover e retornar o elemento no topo da pilha (`pop`).
- Visualizar o elemento no topo da pilha sem removê-lo (`peek`).
- Verificar se a pilha está vazia e obter o tamanho.
- Operações eficientes de inserção e remoção em O(1).

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

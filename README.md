
# Modelagem de Dados UML (Análise&Projeto Orientado a Objetos)

https://www.udemy.com/course/uml-diagrama-de-classes/

Curso completo de modelagem conceitual com UML. Teoria e prática! Bônus: projeto Java, Spring Boot e Hibernate/JPA

## <a name="indice">Índice</a>

1. [Seção 1 - Introdução](#parte1)     
2. [Seção 2 - Identificação de conceitos e atributos](#parte2)     
3. [Seção 3 - Associações e multiplicidades de papéis](#parte3)     
4. [Seção 4 - Associações todo-parte e classes de associação](#parte4)     
5. [Seção 5 - Herança, Enumerações e Tipos Primitivos](#parte5)     
6. [Seção 6 - Estudo de caso: Implementação Java com Spring Boot e JPA](#parte6)     
7. [Seção 7 - Seção bônus](#parte7)     
---


## <a name="parte1">1 - Seção 1 - Introdução</a>

### 1 Visão geral do curso



### 2 Material de apoio do capítulo

- [01-A01+Entendendo+modelagem+de+domínio+e+modelagem+conceitual.pdf](/Secao-01-Introducao/00-apoio/01-A01+Entendendo+modelagem+de+domínio+e+modelagem+conceitual.pdf)

### 3 Entendendo Modelagem de Domínio e Modelagem Conceitual




[Voltar ao Índice](#indice)

---


## <a name="parte2">2 - Seção 2 - Identificação de conceitos e atributos</a>

### 04 Material de apoio do capítulo

- [02-A01+Modelo+conceitual,+conceitos+e+atributos.pdf](/Secao-02-Identificacao-de-conceitos-e-atributos/01-apoio/02-A01+Modelo+conceitual,+conceitos+e+atributos.pdf)

- [02-A02+Como+identificar+conceitos.pdf](/Secao-02-Identificacao-de-conceitos-e-atributos/01-apoio/02-A02+Como+identificar+conceitos.pdf)


### 05 Modelo conceitual, conceitos e atributos

Definição 1: é um modelo que descreve a estrutura das informações que o sistema vai gerenciar (Wazlawick)
- Definição 2: é o Modelo de Domínio em nível de Análise:
- Pertence ao escopo do problema e não ao escopo da solução
- Independente de paradigma
- Independente de tecnologia

* Modelo de domínio: modelo que descreve as entidades do domínio, bem como as interrelações entre elas.

- Para representar o Modelo Conceitual, vamos utilizar a ferramenta:
- Diagrama de Classes da UML

- O Modelo Conceitual descreve:
  - Conceitos
  - Atributos
  - Associações

![img.png](img/05_01_.png)


Conceitos: 

- Um conceito pode ser qualquer entidade que tenha um significado para o sistema e que tenha uma necessidade de armazenamento de dados.
  - Exemplos: cliente, pedido, produto, fornecedor, etc.
- Um conceito deve ser uma unidade coesa. (Não se deve misturar informações de várias coisas distintas em um mesmo conceito)
  
Atributos
- Informações alfanuméricas simples, como números, textos, datas, etc. contidas em cada conceito.### 06 Como identificar conceitos
  - Produto: descrição, preço
  - Cliente: nome, email, telefone, CPF, dataNascimento


- Notas (1FN):
  - Não pode ser multivalorado
    - RUIM: telefones ("3736-3938, 9988-3346, 3210-3939")
  - Não pode ser composto
    - RUIM: endereço ("Rua Floriano Peixoto, n° 250, apto 302, Bairro Copacabana, CEP 38410-384")
    - BOM: logradouro, numero, complemento, bairro, cep

---

#### Resumo da IA (DeepSeek)

## 1. O que é um Modelo Conceitual?

### Definição
O **Modelo Conceitual** é uma representação abstrata das **informações que o sistema deve gerenciar**, descrevendo:
- **Entidades** (conceitos do negócio)
- **Atributos** (propriedades dessas entidades)
- **Relacionamentos** (como as entidades se conectam)

### Características Principais
✅ **Modelo de Domínio em Nível de Análise**:
   - Foca no **problema** (não na solução técnica)
   - Exemplo: Em um sistema de e-commerce, o modelo conceitual define `Cliente`, `Produto` e `Pedido`, mas não como serão implementados

✅ **Independente de Tecnologia e Paradigma**:
   - Não assume se será OO, relacional ou funcional
   - Exemplo: O conceito `Pagamento` pode virar uma classe (Java), uma tabela (SQL) ou um documento (MongoDB)

✅ **Pertence ao Escopo do Problema**:
   - Representa **o que o sistema precisa saber**, não **como fará isso**

---

## 2. Conceitos no Modelo Conceitual

### Definição
Um **conceito** é algo que:
- Tem **significado para o negócio**
- Precisa ser **armazenado ou gerenciado** pelo sistema
- É uma **unidade coesa** (não pode ser dividido sem perder sentido)

### Exemplos
✔ **Boas Práticas** (Conceitos bem definidos):
- `Cliente` (em um sistema de vendas)
- `Consulta` (em um sistema médico)
- `Livro` (em uma biblioteca)

✖ **Más Práticas** (Conceitos mal definidos):
- `ProcessarPedido` (não é um conceito, é uma ação → deveria ser um **caso de uso**)
- `DadosDoUsuario` (muito vago → deve ser dividido em `Usuário`, `Perfil`, `Endereço`)

---

## 3. Atributos no Modelo Conceitual

### Definição
Um **atributo** é uma informação **simples e atômica** (não pode ser dividida) associada a um conceito.

### Regras Básicas (1FN - Primeira Forma Normal)
✅ **Não pode ser multivalorado**:
   - ✖ `telefones: [String]` (lista) → ✔ `telefone: String` (e relacionar com uma nova classe `Telefone` se necessário)
   
✅ **Não pode ser composto**:
   - ✖ `endereco: {rua, cidade, CEP}` → ✔ separar em `rua: String`, `cidade: String`, `CEP: String`

### Tipos de Atributos em UML

| Tipo               | Exemplo                     | Notação UML            |
|--------------------|-----------------------------|------------------------|
| **Atributo Simples** | `nome: String`             | `nome: String`         |
| **Identificador (OID)** | `<<oid>> id: Integer`   | `<<oid>> id: Integer`  |
| **Valor Inicial**   | `desconto: Double = 0`     | `desconto: Double = 0` |
| **Atributo Derivado** | `/ valorLiquido: Double`  | `/ valorLiquido: Double` |

### Exemplo Prático (Classe `Pedido`)

```mermaid
classDiagram
    class Pedido {
        <<oid>> codPedido : Integer
        data : Date
        observacao : String
        valorBruto : Double
        desconto : Double = 0
        / valorLiquido : Double = valorBruto - desconto
    }
```

**Explicação**:
- `codPedido` é o **identificador único** (`<<oid>>`)
- `desconto` tem **valor inicial 0**
- `valorLiquido` é **derivado** (calculado a partir de outros atributos)

---

## 4. Representação em UML (Diagrama de Classes)

### Boas Práticas
✔ **Nomes claros e no singular** (`Pedido`, não `Pedidos`)  
✔ **Atributos atômicos** (evitar composição)  
✔ **Relacionamentos explícitos**:
- Ex: `Cliente "1" -- "*" Pedido : realiza`

### Más Práticas
✖ **Misturar conceitos e regras de negócio**:
- Ex: Adicionar `calcularTotal()` no modelo conceitual (isso é **design**, não análise)
  ✖ **Usar tipos complexos**:
- Ex: `endereco: Endereço` (melhor decompor em `rua`, `cidade`, etc.)

---

## 5. Exemplo Completo (Sistema de Biblioteca)

### Modelo Conceitual
```mermaid
classDiagram
    class Livro {
        <<oid>> isbn : String
        titulo : String
        autor : String
        / disponivel : Boolean
    }
    class Leitor {
        <<oid>> id : Integer
        nome : String
        email : String
    }
    class Emprestimo {
        <<oid>> id : Integer
        dataEmprestimo : Date
        dataDevolucao : Date
    }
    Leitor "1" -- "*" Emprestimo : realiza
    Livro "1" -- "*" Emprestimo : associado
```

**Observações**:
- `disponivel` é **derivado** (depende do estado dos empréstimos)
- Não há métodos como `renovarEmprestimo()` (isso seria parte do **modelo de design**)

---

## 6. Referências
- **Wazlawick, R. S.** - *Análise e Projeto de Sistemas de Informação Orientados a Objetos* (2017)
- **Fowler, Martin** - *UML Essencial* (3ª ed.)
- **Evans, Eric** - *Domain-Driven Design* (2004)


### 6 Como identificar conceitos

- [02-A02+Como+identificar+conceitos.pdf](/Secao-02-Identificacao-de-conceitos-e-atributos/01-apoio/02-A02+Como+identificar+conceitos.pdf)

---

#### Resumo AI - DEEPSEEK

## 📌 Fontes para Identificação de Conceitos

### 📚 Documentos-chave:
- **Visão geral do sistema** (documento descritivo)
- **Casos de uso** (interações sistema-ator)
- Processos de negócio, regulamentos e leis
- Entrevistas com especialistas do domínio

### Exemplo Prático (Sistema Acadêmico):
```text
"Registram-se cursos (nome, carga horária, valor), turmas (número, data início, vagas) e 
matrículas (data, prestações). Alunos possuem nome, CPF e data nascimento. Avaliações 
registram notas, com aprovação ≥70% da nota prevista."
```

### ✔ Boas Práticas:
- Extrair substantivos: `Curso`, `Turma`, `Matrícula`, `Aluno`, `Avaliação`
- Atributos coerentes: `Curso.cargaHoraria`, `Aluno.cpf`

### ✖ Más Práticas:
- Ignorar relações: Não conectar `Aluno` ↔ `Matrícula`
- Atributos compostos: `endereco: {rua, cidade, CEP}` (viola 1FN)

---

## 🔍 Técnicas de Identificação

### 🎯 Estratégias:
1. **Substantivos** (pessoa, lugar, coisa)
  - Ex: `Livro`, `Comprador`, `Pagamento`
2. **Expressões substantivadas**
  - Ex: "autorização de pagamento" → `AutorizacaoPagamento`
3. **Verbos que geram conceitos**
  - Ex: "realizar venda" → `Venda`

### Exemplo de Caso de Uso (Compra de Livros):
```text
1. Comprador informa identificação
2. Sistema mostra livros (título, capa, preço)
3. Comprador seleciona livros
4.1 Finaliza compra (cartão, endereço, frete)
4.2 Guarda carrinho (prazo de validade)
```

### ✔ Modelo Correto:
```mermaid
classDiagram
    class Comprador {
        <<oid>> cpf : String
        nome : String
        endereco : String
    }
    class Livro {
        titulo : String
        preco : Double
    }
    class Venda {
        frete : Double
        totalGeral : Double
    }
    Comprador "1" -- "*" Venda
    Venda "*" -- "*" Livro
```

### ✖ Erro Comum:
- Incluir atributos de relacionamento como campos:
  ```text
  class Funcionario {
      telefoneDepartamento : String  // Anti-padrão!
  }
  ```
  **Solução correta**: Relacionar com classe `Departamento`

---

## 💡 Lições-Chave

1. **Documentos insuficientes** exigem complementação com entrevistas
2. **Evitar**:
  - Atributos multivalorados (`telefones: List`)
  - Misturar conceitos (ex: `DadosPagamento` vs `Cartao`+`Venda`)
3. **Validar** com especialistas do domínio

## 📚 Referências
- Alves, Nelio. *Modelagem Conceitual com UML* (Udemy, 2017)
- Wazlawick, R.S. *Análise e Projeto de Sistemas* (2011)
- Fowler, M. *UML Essencial* (3ª ed.)

> **Nota**: Exemplos adaptados do material do Prof. Dr. Nelio Alves (https://www.udemy.com/user/nelio-alves)


### 07 Exercícios de fixação

[02-E01+exercicios-fixacao-identificacao-de-conceitos-e-atributos.pdf](Secao-02-Identificacao-de-conceitos-e-atributos/01-apoio/02-E01+exercicios-fixacao-identificacao-de-conceitos-e-atributos.pdf)

Exercício 1 (RESOLVIDO): Deseja-se construir um sistema para manter um registro de artistas musicais e seus álbuns. Cada álbum possui várias músicas, as quais poderão ser consultadas pelo sistema. O sistema também deve permitir a busca de artistas por nome ou nacionalidade. O sistema também deve ser capaz de exibir um relatório dos álbuns de um artista, o qual pode ser ordenado por nome, ano, ou duração total do álbum. Um álbum pode ter a participação de vários artistas, sem distinção. Já a música pode possuir um ou mais autores e intérpretes (todos considerados artistas).

Exercício 2: Deseja-se construir um sistema para gerenciar as informações de campeonatos de handebol, que ocorrem todo ano. Deseja-se saber nome, data de nascimento, gênero e altura dos jogadores de cada time, bem qual deles é o capitão de cada time. Cada partida do campeonato ocorre em um estádio, que possui nome e endereço. Cada time possui seu estádio-sede e, assim, cada partida possui um time mandante (anfitrião) e o time visitante. O sistema deve ser capaz de listar as partidas já ocorridas e não ocorridas de um campeonato. O sistema deve também ser capaz de listar a tabela do campeonato, ordenando os times por classificação, que é calculada em primeiro lugar por saldo de vitórias e em segundo lugar por saldo de gols.

Exercício 3: Deseja-se fazer um sistema de rede social. Nesta rede social, os usuários podem seguir e ser seguidos por outros usuários. O perfil do usuário deve permitir cadastrar nome, email, data de nascimento, website, gênero, telefone e foto do perfil. Os usuários podem fazer postagens de texto em sua própria "linha do tempo" (timeline) da rede social, sendo que podem anexar também fotos às postagens. Uma foto é referenciada pela URI de seu local de armazenamento. As fotos podem ser organizadas em álbuns, sendo que cada álbum possui um título.


### 08 Instalação do Astah



### 09 Exercício resolvido 1

![](/Secao-02-Identificacao-de-conceitos-e-atributos/02-Exercicio01/%2009-Exercicio1.jpg)

### 10 Correção do exercício 2

![](/Secao-02-Identificacao-de-conceitos-e-atributos/02-Exercicio02/Class%20Diagram0.png)

### 11 Correção do exercício 3

![](/Secao-02-Identificacao-de-conceitos-e-atributos/02-Exercicio03/Class%20Diagram3.png)


[Voltar ao Índice](#indice)

---


## <a name="parte3">3 - Seção 3 - Associações e multiplicidades de papéis</a>

### 12 Material de apoio do capítulo

- [03-A01+Associações.pdf](/Secao-03-Associacoes-e-multiplicidades-de-papeis/00-apoio/03-A01+Associações.pdf)
- [03-A02+Multiplicidade+de+papéis.pdf](/Secao-03-Associacoes-e-multiplicidades-de-papeis/00-apoio/03-A02+Multiplicidade+de+papéis.pdf)
- [03-A03+Conceito+dependente,+associações+obrigatórias,+múltiplas+e+autoassociações.pdf](/Secao-03-Associacoes-e-multiplicidades-de-papeis/00-apoio/03-A03+Conceito+dependente,+associações+obrigatórias,+múltiplas+e+autoassociações.pdf)
- [03-A04+Desenhando+instâncias+com+diagrama+de+objetos+da+UML.pdf](/Secao-03-Associacoes-e-multiplicidades-de-papeis/00-apoio/03-A04+Desenhando+instâncias+com+diagrama+de+objetos+da+UML.pdf)

### 13 Associações

Associação é um relacionamento estático entre dois conceitos.

![img.png](img/13_1_associacao.png)

![img.png](img/13_2_associacao2.png)



### 14 Multiplicidades de papéis

É a quantidade mínima e máxima de objetos que uma associação permite em cada um de seus papéis.

Exemplo: um carro pode ter quantos donos?
Mínimo: 1
Máximo: 1


![img.png](img/14_1_multiplicidades.png)


Multiplicidades possíveis

"," significa "ou"
".." significa "a"
"*" significa "vários" (sem limite específico)


a) 1 exatamente um
b) 2 exatamente dois
c) 0..1 zero a um
d) 0..* zero ou mais
e) * zero ou mais
f) 1..* um ou mais
g) 2..* dois ou mais
h) 2..5 de dois a cinco
i) 2,5 dois ou cinco
j) 2,5..8 dois ou cinco a oito


Associações comuns

![img.png](img/14_2_umPum.png)

![img.png](img/14_3_umPum2.png)

![img.png](img/14_3_muitosPum.png)



### 15 Conceito dependente, associações obrigatórias, múltiplas e autoassociações

Associação obrigatória

Uma associação é obrigatória se o conceito associado desempenha um papel de multiplicidade mínima maior que zero

![img.png](img/15_1_associacaoObrigatoria.png)

- A associação de uma pessoa com carros não é obrigatória. 
- A associação de um carro com dono é obrigatória.

![img.png](img/15_2_atencaoAssociacaoObr.png)



Conceito dependente

Um conceito é dependente se ele possuir pelo menos uma associação obrigatória.

![img.png](img/15_3_ConceitoDependente.png)

Nota

A UML tem um símbolo que denota dependência de um modo geral, mas que não acrescenta valor prático à modelagem conceitual:

![img.png](img/15_4_notaConcDepen.png)


Associações múltiplas

![img.png](img/15_5_multiplas.png)

Os nomes de papel devem ser únicos.

![img.png](img/15_6_NomesUnicos.png)

Autoassociações

Quando um conceito é associado com ele próprio.

![img.png](img/15_7_associacaoProprio.png)

### 16 Desenhando instâncias com o diagrama de objetos da UML

Recordando
- O Modelo Conceitual representa a estrutura dos dados
  - Conceitos/atributos e como eles se inter-relacionam entre si

- Cada ocorrência de um conceito é chamada de instância ou objeto


Pra quê visualizar as instâncias (ou objetos)?
- Ajuda a compreender
- Ajuda a descobrir problemas
- Ferramenta UML: diagrama de objetos



### 17 Exercícios de fixação

- [03-E01+exercicios-fixacao-associacoes-e-multiplicidades.pdf](/Secao-03-Associacoes-e-multiplicidades-de-papeis/00-apoio/03-E01+exercicios-fixacao-associacoes-e-multiplicidades.pdf)

### 18 Exercício resolvido 1

Exercício 1 (RESOLVIDO): Deseja-se construir um sistema para manter um registro de artistas musicais e seus álbuns. Cada álbum possui várias músicas, as quais poderão ser consultadas pelo sistema. O sistema também deve permitir a busca de artistas por nome ou nacionalidade. O sistema também deve ser capaz de exibir um relatório dos álbuns de um artista, o qual pode ser ordenado por nome, ano, ou duração total do álbum. Um álbum pode ter a participação de vários artistas, sem distinção. Já a música pode possuir um ou mais autores e intérpretes (todos considerados artistas).

Instância mínima: 2 artistas, 3 álbuns, 4 músicas

![classes.png](Secao-03-Associacoes-e-multiplicidades-de-papeis/01-exercicio2/classes.png)

![objs.png](Secao-03-Associacoes-e-multiplicidades-de-papeis/01-exercicio2/objs.png)


### 19 Exercício resolvido 2

Exercício 2 (RESOLVIDO): Deseja-se construir um sistema para gerenciar as informações de campeonatos de handebol, que ocorrem todo ano. Deseja-se saber nome, data de nascimento, gênero e altura dos jogadores de cada time, bem como qual deles é o capitão de cada time. Cada partida do campeonato ocorre em um estádio, que possui nome e endereço. Cada time possui seu estádio-sede e, assim, cada partida possui um time mandante (anfitrião) e o time visitante. O sistema deve ser capaz de listar as partidas já ocorridas e não ocorridas de um campeonato. O sistema deve também ser capaz de listar a tabela do campeonato, ordenando os times por classificação, que é calculada em primeiro lugar por saldo de vitórias e em segundo lugar por saldo de gols.

Instância mínima: 1 campeonato, 2 partidas, 2 times, 2 jogadores em cada time

- [Secao-03-Associacoes-e-multiplicidades-de-papeis/01-exercicio3](Secao-03-Associacoes-e-multiplicidades-de-papeis/01-exercicio3)



### 20 Correção do exercício 3

Exercício 3: Deseja-se fazer um sistema de rede social. Nesta rede social, os usuários podem seguir e ser seguidos por outros usuários. O perfil do usuário deve permitir cadastrar nome, email, data de nascimento, website, gênero, telefone e foto do perfil. Os usuários podem fazer postagens de texto em sua própria "linha do tempo" (timeline) da rede social, sendo que podem anexar também fotos às postagens. Uma foto é referenciada pela URI de seu local de armazenamento. As fotos podem ser organizadas em álbuns, sendo que cada álbum possui um título.

Instância mínima: 4 usuários, pelo menos um usuário com mais de uma postagem, pelo menos um álbum com mais de uma foto.

- [Secao-03-Associacoes-e-multiplicidades-de-papeis/20-exercicio-3](Secao-03-Associacoes-e-multiplicidades-de-papeis/20-exercicio-3)

### 21 Correção do exercício 4

Exercício 4: Deseja-se construir um sistema para gerenciar as informações dos participantes das atividades de um evento acadêmico. As atividades deste evento podem ser, por exemplo, palestras, cursos, oficinas práticas, etc. Cada atividade que ocorre possui nome, descrição, preço, e pode ser dividida em vários blocos de horários (por exemplo: um curso de HTML pode ocorrer em dois blocos, sendo necessário armazenar o dia e os horários de início de fim do bloco daquele dia). Para cada participante, deseja-se cadastrar seu nome e email.

Instância mínima: 2 atividades, 4 participantes, pelo menos uma atividade com mais de um bloco de horários.

[21-Correcao-do-exercicio-4](Secao-03-Associacoes-e-multiplicidades-de-papeis/21-Correcao-do-exercicio-4)


### 22 Correção do exercício 5

Exercício 5: Deseja-se fazer um sistema para manter dados de cidades (nome, estado, website), onde cada cidade possui um ou mais restaurantes (nome, valor da refeição) e hotéis (nome, valor da diária). Além disso, deseja-se registrar pacotes turísticos vendidos. Para registrar um pacote turístico, deve-se escolher uma cidade, definir a data da viagem, o hotel de hospedagem e o número de dias de permanência. Deve-se também definir se no pacote vai estar incluso ou não um restaurante e, se sim, quantas refeições por dia serão consumidas.

Instância mínima: 1 cidade, 2 hotéis e 2 restaurantes, 2 pacotes turísticos.

[22-Correcao-do-0exercicio-5](Secao-03-Associacoes-e-multiplicidades-de-papeis/22-Correcao-do-0exercicio-5)



[Voltar ao Índice](#indice)

---


## <a name="parte4">4 - Seção 4 - Associações todo-parte e classes de associação</a>


### 23 Material de apoio do capítulo

[04-A01+Associações+todo-parte.pdf](Secao-04-Associacaes-todo-parte-e-classes-de-associacao/00-apoio/04-A01%2BAssocia%C3%A7%C3%B5es%2Btodo-parte.pdf)

[04-A02+Classe+de+associação.pdf](Secao-04-Associacaes-todo-parte-e-classes-de-associacao/00-apoio/04-A02%2BClasse%2Bde%2Bassocia%C3%A7%C3%A3o.pdf)


### 24 Associação todo-parte

Quando um conceito é parte de outro que representa um todo, desenhamos um diamante no lado do todo.

![img.png](img/24_1-associacao-todo-parte.png)

#### Exclusividade: 1 ou 0..1

Como a composição (diamante preto) é uma relação exclusiva, a multiplicidade no lado do diamante sempre será 1 ou 0..1

![img.png](img/14_2-exclusividade-1_0-1.png)

Agregação - exemplo 2

![img.png](img/24_3-agregacao-ex2.png)

Agregação - exemplo 3

![img.png](img/24_4-agregacao-ex3.png)

#### Ressalva 1

O diamante (seja branco, seja preto) deve ser usado somente em casos em que realmente se trata de uma relação todo-parte

![img.png](img/24_5-ressalva_1.png)


#### Ressalva 2

Algumas pessoas confundem o diamante preto (composição) como se fosse uma forma de indicar a deleção em cascata dos objetos dependentes. Na verdade o que indica isso é a multiplicidade.

![img.png](img/24_5-ressalva2.png)

- Associações todo-parte
  - Agregação - diamante branco - mais fraca
  - Composição - diamante preto - mais forte - exclusiva (1 ou 0..1)
- Ressalvas
  - Use diamante somente quando realmente for uma associação todo-parte 
  - Não é a composição que indica deleção em cascata

---

RESUMO GEMINI

As associações **todo-parte** em UML são usadas para modelar relacionamentos onde uma classe (o "todo") é composta por, ou contém, instâncias de outra(s) classe(s) (as "partes"). Essas associações são fundamentais para representar a estrutura e a composição dos objetos em um sistema. Existem dois tipos principais: **Agregação** e **Composição**.

---

### Resumo do Tema: Associação Todo-Parte

Uma associação todo-parte descreve como um objeto "todo" é constituído por outros objetos "parte". A distinção principal entre os tipos de associação todo-parte reside na força do relacionamento e na dependência do ciclo de vida entre o todo e suas partes.

#### 1. Agregação (Aggregation) ⚪

A **agregação** representa uma relação "tem-um" ou "contém-um" mais fraca.
* **Características Principais:**
  * As partes podem existir independentemente do todo.
  * Se o "todo" for destruído, as "partes" podem continuar a existir e, potencialmente, ser associadas a outros "todos".
  * Uma "parte" pode ser compartilhada entre vários "todos" (embora isso deva ser modelado com cuidado para não gerar confusão).
* **UML:** Representada por um losango **vazado** (◇) no lado da classe "todo".
* **Quando usar:** Ideal para representar coleções de objetos onde a remoção do contêiner não implica na remoção dos objetos contidos.

**Exemplo UML (Agregação):** Uma `Universidade` possui `Departamentos`. Se a `Universidade` deixar de existir, os `Departamentos` podem, conceitualmente, continuar existindo ou serem incorporados por outra instituição. Um `Departamento` também pode agregar `Professores`.

```mermaid
classDiagram
    Universidade "1" o-- "1..*" Departamento : possui
    Departamento "1" o-- "1..*" Professor : agrega
    class Universidade {
        -String nome
        +List~Departamento~ departamentos
    }
    class Departamento {
        -String nome
        +List~Professor~ professores
    }
    class Professor {
        -String nome
        -String especialidade
    }
```

**Exemplo em Código Java (Agregação):**

```java
import java.util.ArrayList;
import java.util.List;

// Classe Parte
class Professor {
    private String nome;
    private String especialidade;

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        System.out.println("Professor(a) " + nome + " (" + especialidade + ") criado(a).");
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome='" + nome + '\'' + ", especialidade='" + especialidade + '\'' + '}';
    }
}

// Classe Todo (que agrega Professores)
class Departamento {
    private String nome;
    private List<Professor> professores; // Agregação

    public Departamento(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
        System.out.println("Departamento de " + nome + " criado.");
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
        System.out.println(professor.getNome() + " adicionado ao departamento de " + this.nome);
    }

    public void listarProfessores() {
        System.out.println("Professores do departamento de " + nome + ":");
        for (Professor p : professores) {
            System.out.println("- " + p.getNome());
        }
    }
    // Se o departamento for extinto, os professores (objetos) podem continuar existindo.
}

public class ExemploAgregacao {
    public static void main(String[] args) {
        Professor prof1 = new Professor("Dr. Silva", "Inteligência Artificial");
        Professor prof2 = new Professor("Dra. Costa", "Banco de Dados");

        Departamento deptComputacao = new Departamento("Ciência da Computação");
        deptComputacao.adicionarProfessor(prof1);
        deptComputacao.adicionarProfessor(prof2);

        deptComputacao.listarProfessores();

        // Mesmo que 'deptComputacao' seja descontinuado ou o objeto seja coletado pelo GC,
        // 'prof1' e 'prof2' ainda existem e podem ser associados a outros departamentos.
        // deptComputacao = null;
        // System.out.println(prof1); // prof1 ainda é uma instância válida.
    }
}
```

---

#### 2. Composição (Composition) ⚫

A **composição** representa uma relação de pertencimento forte, onde as "partes" são exclusivamente possuídas pelo "todo" e seu ciclo de vida é estritamente dependente dele.
* **Características Principais:**
  * As "partes" não existem independentemente do "todo".
  * Se o "todo" é destruído, as "partes" associadas também são destruídas.
  * Uma "parte" pertence a apenas um "todo" em um determinado momento.
* **UML:** Representada por um losango **preenchido** (◆) no lado da classe "todo".
* **Quando usar:** Para relações onde a parte é um componente intrínseco e exclusivo do todo. Garante forte integridade dos dados e do ciclo de vida.

**Exemplo UML (Composição):** Um `Livro` é composto por `Capítulos`. Se o `Livro` é destruído (ex: retirado de catálogo e todas as cópias físicas/digitais eliminadas), seus `Capítulos` deixam de existir como parte daquele livro. Um `Carro` é composto por um `Motor` específico.

```mermaid
classDiagram
    Livro "1" *-- "1..*" Capitulo : é composto por
    Carro "1" *-- "1" Motor : possui
    class Livro {
        -String titulo
        +List~Capitulo~ capitulos
        +adicionarCapitulo(String tituloCap)
    }
    class Capitulo {
        -String titulo
        -int numeroPaginas
    }
    class Carro {
        -String modelo
        +Motor motor
    }
    class Motor {
        -String numeroSerie
        -int potenciaHP
    }
```

**Exemplo em Código Java (Composição):**

```java
import java.util.ArrayList;
import java.util.List;

// Classe Parte (ciclo de vida gerenciado pelo Livro)
class Capitulo {
    private String titulo;
    private int numeroPaginas;
    // Geralmente, a parte não tem uma referência explícita e navegável de volta ao todo
    // para reforçar a ideia de que é gerenciada pelo todo.

    // Construtor geralmente chamado pela classe "Todo"
    public Capitulo(String titulo, int numeroPaginas) {
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
        System.out.println("Capítulo '" + titulo + "' criado.");
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Capitulo{" + "titulo='" + titulo + '\'' + ", paginas=" + numeroPaginas + '}';
    }
}

// Classe Todo
class Livro {
    private String titulo;
    private List<Capitulo> capitulos; // Composição

    public Livro(String titulo) {
        this.titulo = titulo;
        this.capitulos = new ArrayList<>(); // A lista de capítulos é criada com o livro
        System.out.println("Livro '" + titulo + "' criado.");
    }

    // O Livro é responsável pela criação de seus Capítulos
    public void adicionarCapitulo(String tituloCapitulo, int numPaginas) {
        Capitulo novoCapitulo = new Capitulo(tituloCapitulo, numPaginas);
        this.capitulos.add(novoCapitulo);
    }

    public void exibirSumario() {
        System.out.println("Sumário do Livro: " + titulo);
        for (int i = 0; i < capitulos.size(); i++) {
            System.out.println((i + 1) + ". " + capitulos.get(i).getTitulo());
        }
    }

    // Quando um objeto Livro é destruído (coletado pelo Garbage Collector, por exemplo),
    // os objetos Capitulo contidos em sua lista 'capitulos' também se tornarão
    // elegíveis para coleta, assumindo que não há outras referências a eles
    // (o que violaria a premissa da composição forte).
}

public class ExemploComposicao {
    public static void main(String[] args) {
        Livro meuLivro = new Livro("A Arte da Modelagem");
        meuLivro.adicionarCapitulo("Introdução", 10);
        meuLivro.adicionarCapitulo("Associações", 25);
        meuLivro.adicionarCapitulo("Herança", 15);

        meuLivro.exibirSumario();

        // Se 'meuLivro' for tornado null e não houver outras referências,
        // os capítulos "Introdução", "Associações", "Herança" também
        // perderão sua referência primária e serão elegíveis para coleta de lixo.
        // meuLivro = null;
    }
}
```

---

### Boas Práticas 👍 e Más Práticas 👎 para Associações Todo-Parte

#### Boas Práticas 👍:

1.  **Escolha Semântica Clara:** Decida entre agregação e composição com base no significado real da relação no domínio do problema. Pergunte-se: "A parte pode existir sem o todo?".
2.  **Gerenciamento do Ciclo de Vida (Composição):** Na composição, a classe "todo" deve gerenciar a criação e destruição de suas partes. Se o "todo" é deletado, as partes devem ser deletadas também.
3.  **Multiplicidades Corretas:** Defina as multiplicidades (cardinalidades) em ambos os lados da associação para refletir as regras de negócio (ex: um `Carro` *tem exatamente um* `Motor`; uma `Equipe` *tem muitos* `Jogadores`).
4.  **Coesão (Composição):** A composição ajuda a criar objetos mais coesos, onde o "todo" encapsula fortemente suas partes.
5.  **Clareza no Diagrama:** Use os símbolos UML corretos (losango vazado para agregação, preenchido para composição) para comunicar a intenção do design.

#### Más Práticas 👎:

1.  **Confundir Agregação com Composição:** Usar agregação quando a parte depende vitalmente do todo (ou vice-versa) pode levar a problemas de integridade de dados e objetos "órfãos".
2.  **Uso Excessivo de Composição:** Nem toda relação "tem-um" é uma composição. Aplicá-la indiscriminadamente pode tornar o modelo rígido e dificultar o reuso de componentes.
3.  **Agregação Trivial:** Usar agregação para relações que são meras associações simples sem uma clara semântica de "todo-parte". Por exemplo, `Cliente` e `Endereco` pode ser uma composição (se o endereço só existe para aquele cliente) ou uma associação simples (se endereços podem ser compartilhados ou existem independentemente).
4.  **Violar o Ciclo de Vida da Composição:** Permitir que "partes" de uma composição existam após a destruição do "todo" ou sejam compartilhadas entre múltiplos "todos" que as compõem.
5.  **Esquecer da Navegabilidade:** Embora não exclusivo de todo-parte, pense se a navegação é unidirecional (do todo para a parte) ou bidirecional, e represente isso adequadamente. Na composição, a navegação da parte para o todo é menos comum ou até desencorajada para reforçar a dependência.

Entender bem a diferença e a aplicação correta de agregação e composição é crucial para criar modelos de dados e de objetos robustos e significativos.


---

### 25 Classe de associação



### 26 Exercícios de fixação



### 27 Exercício resolvido 1 - Parte 1/3



### 28 Exercício resolvido 1 - Parte 2/3



### 29 Exercício resolvido 1 - Parte 3/3



### 30 Correção do exercício 2



### 31 Correção do exercício 3





[Voltar ao Índice](#indice)

---


## <a name="parte5">5 - Seção 5 - Herança, Enumerações e Tipos Primitivos</a>



[Voltar ao Índice](#indice)

---


## <a name="parte6">6 - Seção 6 - Estudo de caso: Implementação Java com Spring Boot e JPA</a>



[Voltar ao Índice](#indice)

---


## <a name="parte7">7 - Seção 7 - Seção bônus</a>



[Voltar ao Índice](#indice)

---

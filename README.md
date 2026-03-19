# Back-End Lab (Spring Boot)

Projeto de aprendizado com um exemplo mínimo de API e frontend estático.

## O que tem no projeto

- `BackEndLabApplication` (Spring Boot)
  - `CommandLineRunner helloTerminal()` imprime no console:
    - sem args: `Olá Mundo do terminal!`
    - com arg: `Olá <nome> do terminal!`
- `HelloController`:
  - `GET /olamundo?nome=...` retorna `Olá <nome> da web!`
- `src/main/resources/static/index.html`:
  - frontend simples que consome `/olamundo` via JavaScript `fetch`

## Como executar

1. `./mvnw clean package` (ou `./mvnw spring-boot:run`)
2. `./mvnw spring-boot:run`
3. Abrir navegador: `http://localhost:8080/`

### Clonar e executar pelo VS Code

1. Abra o VS Code.
2. Vá para a aba **Source Control** (ícone de ramo) e clique em **Clone Repository**.
3. Cole o URL `https://github.com/thiagoprazeres-alpha/br.edu.alpha.faculdade.lab`.
4. Escolha a pasta local e aguarde o clone.
5. Abra a pasta do projeto no VS Code.
6. No topo direito do VS Code, clique em **Run and Debug** (ícone de play com bug), escolha a configuração Java Spring Boot (ou execute `Spring Boot App`).
7. O VS Code iniciará o servidor com Maven em background; abra `http://localhost:8080/`.

### Terminal com argumento

`./mvnw spring-boot:run -Dspring-boot.run.arguments=Ana`
- Imprime: `Olá Ana do terminal!`

## Como testar endpoints

- `GET http://localhost:8080/` → exibe `index.html`
- `GET http://localhost:8080/olamundo` → `Olá Mundo da web!`
- `GET http://localhost:8080/olamundo?nome=Tiago` → `Olá Tiago da web!`

## Arquitetura e conceito

1. Back-end no centro (Spring Boot):
   - recebe requisição HTTP
   - aplica regra simples (nome _default_ `Mundo`)
   - devolve resposta

2. Cliente-Servidor:
   - navegador ou [Postman](https://www.postman.com/downloads/) manda requisição
   - servidor responde JSON/texto
   - no frontend, JS consome e exibe

3. Regras e contrato REST:
   - método `GET` usado para leitura
   - `200 OK` para sucesso
   - parâmetros em query string (`nome`)

## Observações

- `index.html` é servido diretamente de `src/main/resources/static`.
- `/` não é mais mapeado pelo controller, deixa o Spring servir a página estática.
- `/olamundo` é a rota de API para geração de mensagem.

---

## Exercício

Vamos praticar a ideia de reutilizar código:

No projeto, temos duas partes que fazem quase a mesma coisa:
- `HelloController.helloWeb()` trata a requisição web
- `CommandLineRunner helloTerminal()` imprime no terminal

As duas usam a mesma regra: se o nome não for informado, usa `"Mundo"` e monta a frase `"Olá ..."`.

### Pergunta:
Explique em poucas linhas por que, do ponto de vista de **boa prática de programação** (temas que vocês já viram em Introdução e OO), seria melhor evitar essa repetição.  
[Qual problema pode surgir se a mesma lógica for mantida em dois lugares diferentes?](https://classroom.google.com/c/Nzk0MDI5NjgxMjg1/sa/Nzk2NzU1ODg3NzYx/details)

- gabarito: “repetição causa inconsistência e manutenção difícil; convém isolar a lógica em um único lugar (função/método comum), e chamar de web e terminal.”



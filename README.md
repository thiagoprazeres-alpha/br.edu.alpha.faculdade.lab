  # Back-End Lab (Spring Boot)

  Projeto de aprendizado com um exemplo mínimo de API e frontend estático.

  ---

  ## Referências recomendadas

  ### Spring Boot / API
  - Fernanda Kipper: "[CURSO DE SPRING para INICIANTES | Tutorial Completo de Java Spring](https://www.youtube.com/watch?v=YY_hf0FOIcU)" (YouTube)
  - Michelli Brito: "[Curso de Spring Boot: Criando uma aplicação Java Web](https://www.youtube.com/watch?v=OHn1jLHGptw&list=PL8iIphQOyG-DHLpEx1TPItqJamy08fs1D)" (YouTube)

  ### HTTP / REST / Cliente-Servidor
  - Gustavo Guanabara: "[O QUE É UMA API? ENTENDA DE UMA VEZ POR TODAS](https://www.youtube.com/watch?v=TSLoQzJ-6mw)" (YouTube)
  - MDN HTTP Methods: https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Methods

  ### Frontend (formulário / validador / fetch)
  - MDN Forms: https://developer.mozilla.org/pt-BR/docs/Learn/Forms
  - MDN Fetch API: https://developer.mozilla.org/pt-BR/docs/Web/API/Fetch_API/Using_Fetch

  ---

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
  7. O VS Code iniciará o servidor com Maven em _background_; abra `http://localhost:8080/`.

  ### Terminal com argumento

  `./mvnw spring-boot:run -Dspring-boot.run.arguments=Ana`
  - Imprime: `Olá Ana do terminal!`

  ## Como testar _endpoints_

  - `GET http://localhost:8080/` → exibe `index.html`
  - `GET http://localhost:8080/olamundo` → `Olá Mundo da web!`
  - `GET http://localhost:8080/olamundo?nome=Thiago` → `Olá Thiago da web!`

  ## SPA (Single Page Application)

  Este projeto contém um frontend simples em `src/main/resources/static/index.html` que ilustra um conceito básico de SPA (Single Page Application):

  - a aplicação roda em uma única página (`index.html`) e não recarrega a página inteira em cada interação. 
  - a lógica de interface usa JavaScript `fetch` para chamar a API (`/olamundo`) e atualizar o conteúdo Dinamicamente.
  - o backend devolve apenas dados (texto/JSON), enquanto o frontend trata a renderização no cliente.

  Em projetos maiores, SPA normalmente usam frameworks como React, Vue ou Angular, mas aqui o conceito é mostrado com HTML/JS puro.

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

  ## Exercícios

  1. Conceito rápido sobre back-end:

  ### Pergunta:
  No contexto de uma aplicação web, qual é a principal função do back-end em relação ao cliente? 

  - gabarito: “Recebe requisições do cliente (HTTP)”

  2. Diferença entre invocações:

  ### Pergunta complementar:
  No projeto, temos `HelloController` (API web) e `CommandLineRunner` (CLI). Qual é a diferença de origem das solicitações em cada caso?

  - gabarito esperado: “`HelloController` recebe requisições HTTP de clientes; `CommandLineRunner` é executado localmente sem requisição de cliente.”

  3. Comparação prático / conceitual

  ### Pergunta:
  Quais são os riscos de manter a mesma regra de negócio duplicada em `HelloController` e em `CommandLineRunner`? Cite pelo menos dois impactos na manutenção do código.

  - gabarito: “repetição causa inconsistência e manutenção difícil; se precisar mudar a regra precisa alterar em dois lugares, aumentando chance de erro. Melhor isolar em um único método/componente e reutilizar.”

  4. SPA (Single Page Application)

  ### Pergunta:
  No contexto deste projeto, por que o `index.html` com `fetch('/olamundo')` é considerado um exemplo de SPA? Cite duas características que fazem com que seja diferente de uma aplicação multi-page.

  - gabarito sugerido: “A interação é feita na mesma página, sem reload completo, e apenas os dados são carregados via AJAX/fetch; o front mantem estado e atualiza DOM dinamicamente.”

  5. Terminal com argumento

  ### Pergunta:
  O projeto também usa `CommandLineRunner` para aceitar argumento via terminal (`./mvnw spring-boot:run -Dspring-boot.run.arguments=Ana`). Explique como esse uso mostra outra forma de entrada de dados diferente da SPA e por que ele ainda faz parte do mesmo código-base.

  - gabarito sugerido: “No terminal a entrada é passada como argumento ao iniciar a aplicação, sem HTTP, e o código roda local sem interface web; ambos usam a mesma lógica de mensagem (`Olá ...`) mas em modos de execução diferentes (CLI vs web).”



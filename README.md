# CRUD de criação de conta bancária e usuários

## Motivação
Este projeto é parte dos estudos em JAVA e tem como propósito a criação de um CRUD para cadastro de usuários de um banco e sua respectiva conta.
Existe uma aplicação Front-End desenvolvida para esta aplicação que pode ser acessada em https://github.com/caioproft/BankSpringReactFrontEnd e utilizado em conjunto para facilitar a visualização da aplicação.
Caso opte por não utilizar a aplicação Front-End é necessário que as requisições Http sejam realizadas a partir do POSTMAN ou INSOMNIA, por exemplo.

## Tecnologias utilizadas
- Java
- Framework Spring (Spring Data, Spring MVC, Spring WEB e Spring Boot)
- PostgreSQL
- Gradle

## Guia para uso
1. Clone este repositório para sua máquina 

git clone https://github.com/caioproft/BankSpringReact.git

2. Abra o projeto em sua IDE preferida e aguarde a instalação das dependẽncias
3. Altere os dados de conexão com o banco de dados Postgres para que a aplicação funcione corretamente:
  - Acesse o arquivo application.properties a partir do caminho src -> main -> resources.
  - Altere o campo {DATABASE-NAME} pelo nome dado ao seu banco de dados criado a partir do POSTGRES
  - Altere o campo {USERNAME} pelo seu nome de usuário do POSTGRES
  - Altere o campo {PASSWORD} pela sua senha de usuário do POSTGRES
  
 ## Contribuições
 Fique a vontade para propor melhorias a este projeto a partir de PULL REQUEST. Todas as contribuições são bem vindas!
 
 
 
 


# HACKATHON FIAP - BOOKING

Fala pessoal, esse é um sistema de hospitalidade, em outras palavras é um sistema de gerenciamento de reservas para hotéis, nele será possível agendar, buscar a melhor solução
custo-benefício para o cliente e já pré-agendar com o serviços e opcionais.

## Features

  👤API Clientes, 📒API Localidade, 🏨 API Prédio, 😴 API Quarto, 📅 API Reserva e 🍴 API Serviço Opcional<br>
* GET : filtro por atributos;
* Header: usuario-auth-key: controle de CRUD por usuário*

Domínio usuário
* Criação de DTOs, service, entitie, repository

OBSERVAÇÃO: O requisito do dominio usuário não está claro, optamos por faze-lo da maneira mais simples e facil de refatorar,
que é incluir o campo usuario em cada tabela, fazendo que as APIs gravem ou consultem dados conforme usuario informado no header. 

## Features:

*  🙋🏽‍♀️API Pessoas: "Leitura e escrita dos verbos HTTP"<br>
*  📒API Endereço: "Leitura e escrita dos verbos HTTP"<br>
*  💻API Eletrodomésticos: "Leitura e escrita dos verbos HTTP"<br>

## Tecnologias e ferramentas utilizadas:

* [Spring initializr]( https://start.spring.io/): Ferramenta para criação de projetos Spring Boot
* [Spring Boot ]( https://spring.io/projects/spring-boot): Framework Web 
* [Spring Boot Starter Web] Dependência para desenvolvimento Web
* [Spring Boot Starter Validation] Dependência para validação de formulários
* [Maven]( https://mvnrepository.com/): Gerenciador de dependências do projeto
* [JPA Repository] Gerenciador de interação entre camadas do projeto
* [Lombock] Dependência para requisições HTTP
* [Postman](https://www.postman.com/): Ferramenta para teste de requisições HTTP
* [Open Api - Swagger] Dependência para gerar interface amigável para testes
* [h2] Banco de dados em memória

## Dificuldades encontradas:

Optamos por trabalhar em monolito para criação da nossa aplicação e assim ganhar tempo para desenvolver outras camadas que compõe o projeto;

Optamos por atingir metade da cobertura dos testes para representar o conhecimento adquirido até o momento e seguimos para a próxima etapa do projeto; 

Durante o desenvolvimento do projeto encontramos alguns problemas de interpretação na regra de negócio, tais como, quais seriam os limites de desenvolvimento para este novo desafio: 
* Iria utilizar banco de dados? R: H2
* Qual seria a forma de fazer as simulações de requisições HTTP das API’s? R: swagger-ui / postman (criação de testes automatizados) <br>

Estes foram alguns dos levantamentos feitos pela equipe e a partir deles, começamos a estudar as melhores ferramentas para desenvolver as API’s. E como mencionado nas tecnologias e ferramentas utilizadas focamos nelas em específicos durante o projeto.
A partir desse ponto, realizamos algumas reuniões de alinhamento e planejamento do que seria feito e como seria. 


## Pontos chaves do projeto:

Durante as reuniões no inicio do projeto definimos algumas informações básicas que as API’s iriam precisar para atender ao projeto, e as mapeamos da seguinte forma:
* API Clientes:
ID, nomeCompleto, dataNascimento, CPF, passaporte, paisDeOrigem, endereco, email, telefone, sexo.
* API Localidade:
  ID, nome, amenidades, endereco, cep, numero, complemento, bairro, cidade, estado, predios.
* API Prédio:
  ID, nome, localidade, quartos.
* API Quarto
  ID, tipo, totalPessoas, totalCamas, outrosMoveis, valorDiaria, predio, reservas.
* API Reserva:
  ID, cliente, dataEntrada, dataSaida, totalPessoas, quartos, valorTotal, status.
* API Serviço Opcional:
  ID, nome, valor, tipo (serviço ou item).

## Método de utilização da(s) API(s):

Para demonstração de utilização da(s) API(s) será utilizado o Swagger pela sua interface mais amigável, porém dentro do projeto foi gerado um arquivo de importação Jason do Postman que pode ser utilizado colocando as mesmas informações apresentadas no Swagger.
* [Swagger](http://localhost:8080/booking/swagger-ui/index.html#/) /): Servidor local para teste requisições HTTP (Browser);
* [Arquivo para teste Postman](https://warped-meteor-302132.postman.co/workspace/App-Consumo-Eletro~60891746-3429-418a-9499-910f095c31d9/collection/27681645-57d87472-1132-46fc-8916-268f42ac6cce?action=share&creator=27681645 ): Arquivo para simulação direto na máquina (PC).

## Diagrama de tabelas:
![Imagem do WhatsApp de 2024-03-13 à(s) 15 09 19_4d8cc485](https://github.com/otavioprado/fiap-hackathon-booking/assets/133544024/ad57fc12-7514-4d5c-871e-f9534d2fc710)


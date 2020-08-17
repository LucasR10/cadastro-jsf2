# Cadastro Usuário
   Cadastro de Funcionario está publicado na [DigitalOcean](https://www.digitalocean.com/) mais poderia ser publicado **AWS AC2**! 
   * Link com login http://198.199.91.245:8080/cadastro/login.xhtml
   * Link sem http://198.199.91.245:8080/cadastro2/

## A demanda 
  Deverá ser criada uma aplicação de cadastro de pessoas. A aplicação deverá ser acessível via navegador e possuir uma tela com formulário A aplicação deverá possibilitar que o usuário faça cadastro, alteração, remoção e consulta de pessoas com as seguintes informações.

*  Nome - obrigatório Sexo
*  E-mail - não obrigatório, deve ser validado caso preenchido
*  Data de Nascimento - obrigatório, deve ser validada
*  Naturalidade
*  Nacionalidade
*  CPF - obrigatório, deve ser validado (formato e não pode haver dois cadastros com mesmo CPF)
*  Obs: a data de cadastro e atualização dos dados devem ser armazenados.

## Funcionalidade
* Cadastra funcionário ( Adicona a data de cadastro)
* Deletar funcionário
* Atualizar funcionário
* Excluir funcionário por cpf - ( Adicona a data de atualização)
* Valida se exite funcionário com mesmo CPF
* Como Adicional tem Entidade Usuario para login. 

## Tecnologias para o desafio:
* **Java 8**
* **JSF 2.2**
* **JPA/Hibernate**
* **HTML5 / BootStrap 3.x**
* **CSS**
* **Apache Tomcat 9** 
* **Maven**
* **H2**

## Instalação
 * Baixa java versão 1.8 ou superior e JDK 1.8 instalar as variaves de ambiente.
 * Eclipse 6/2020 para desenvolvimento Web
 * Importar o projeto mavem e executar os seguintes comandos: mvn clean install
 * Adicionar o tocat na versão tomcat 9
 
 Link do Projeto : https://github.com/LucasR10/cadastro-jsf2/

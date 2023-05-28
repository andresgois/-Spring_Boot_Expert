##

- [Eureka Server](http://localhost:8761/)
- []()
- []()
- []()
- []()

## Serviço de clientes
> Salvar cliente
- POST
- http://localhost:8080/clientes
```
{
    "cpf": "04588236698",
    "nome": "teste",
    "idade": 0
}
```
> Listar cliente
- GET
- http://localhost:8080/clientes?cpf=04588236698

## Atalhos
- Cria variavél: *ctrl + alt +v*
- Em cima da classe que não existe: *alt + enter*

## Serviço de Cartões
> Salvar cartoes
- POST
- http://localhost:8080/cartoes
```
{
    "nome": "Alelo",
    "bandeira": "mastercard",
    "renda": 5000.00
}
```
> Listar cartoes
- GET
- http://localhost:8080/cartoes?renda=155669
> Listar cartoes por cliente
- GET
- http://localhost:8080/cartoes?cpf=04588236698

## Avaliador de crédito
> Consulta situação do cliente
- GET
- http://localhost:8080/avaliador-credito?cpf=04588236698


> Realizar avaliação do cliente
- POST
- http://localhost:8080/avaliador-credito
```
{
    "cpf": "04588236698",
    "renda": 5000.00
}
```
### Vai para a fila
> Solicita cartão
- POST
- http://localhost:8080/avaliador-credito
```
{
    "idCartao": "1",
    "cpf": "04588236698",
    "endereco": "rua joão paulo, nº 125",
}
```

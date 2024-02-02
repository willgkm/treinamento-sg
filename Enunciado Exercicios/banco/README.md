# Banco

Criar um sistema que permita o gerenciamento de contas em um banco segundo as seguintes exigências:

 - Permitir o cadastro de Clientes.
 - Permitir a criação de contas para Pessoa Física, Pessoa Jurídica e Poupança.
 - Clientes podem possuir mais de uma conta, mas apenas uma de cada tipo.
 - Controlar o saldo e as operações de Depósito, Saque, Transferência.
 - Cada tipo de conta (exceto a Poupança), possui um limite de crédito padrão assim como uma porcentagem de juros diário padrão.
 - Caso o Cliente precise utilizar o limite de crédito o sistema deve calcular os juros devidos e realizar o desconto automático no próximo Depósito ou Transferência, quando for suficiente para retirar o cliente do limite de crédito (saldo positivo).
 - Os juros devidos só devem ser cobrados na totalidade devida **e** se o saldo após a cobrança não negativo.
 - O sistema deve permitir a geração do extrato de uma conta.
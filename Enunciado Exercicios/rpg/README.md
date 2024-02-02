# Jogo RPG

Realizar a implementação de um jogo de turnos segundo as seguintes exigências:

- Pelo menos 3 Classes de personagens diferentes devem ser implementadas.
- Cada Classe possui um valor de Vida, Ataque, Defesa, Cura e Taxa de Sucesso diferentes.
- O usuário deve escolher com qual Classe quer jogar.
- A Classe do Adversário deve ser escolhida automaticamente pelo sistema.
- A cada turno, tanto o usuário quanto o Adversário dever realizar uma das duas ações: Atacar ou Curar-se.
- O usuário deve escolher qual ação tomar, enquanto a ação do Adversário deve ser automática.
- Não deve ser possível escolher Curar-se duas vezes seguidas.
- A cada Ataque sofrido deverá ser subtraído da vida o valor do Ataque adversário **menos** o valor da Defesa do atacado **considerando a Taxa de Sucesso** da Classe adversária.
- A cada Curar-se utilizado, deve-se **considerar a Taxa de Sucesso** da sua própria Classe.
- Perde aquele que tiver valor de Vida igual ou menor que 0 primeiro.
- A cada turno, deve ser retornado o estado atual do jogo e a lista de ações tomadas nos turnos anteriores.

**Dica:** você pode fazer esse sistema com apenas uma rota de API, que receberá os parâmetros necessários para aquele momento do jogo.
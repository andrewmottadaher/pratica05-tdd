## 1. No Ciclo 1 usamos return 70. Por que isso é aceitável no TDD? O que
obrigou a escrever a soma de verdade? ##
No TDD (Desenvolvimento Orientado a Testes), começamos escrevendo um teste que falha e, em seguida, implementamos o código mínimo necessário para fazê-lo passar. Por isso, o return 70 pode é aceitável, (desde que seja uma solução temporária para atender ao primeiro teste).

## 2. No Ciclo 3, por que testar com 69 e 70, e não com 50 e 90? ##
Como o slide aponta, testar 69 e 70 permite verificar tanto o comportamento imediatamente abaixo do limite quanto o comportamento exatamente no limite. O valor 70 é especialmente importante para detectar a troca acidental de >= por >.

## 3. No Ciclo 4, o que mudou na refatoração? Como você teve certeza de
que não quebrou nada? ##
A refatoração consistiu em eliminar a repetição de código, substituindo os três if independentes por um método privado chamado validarNota(). Esse método centraliza a regra de validação, recebendo a nota, o valor máximo permitido e o nome da avaliação. Assim, o código ficou mais simples, legível e fácil de manter, sem alterar as regras de validação. Para verificar que a refatoração não quebrou nada, executei novamente os testes e confirmei que continuaram passando. (Inclusive, isso caracteriza um teste de regressão, pois verifica se alterações feitas no código preservam comportamentos que já funcionavam!)

4. No Ciclo 8, por que alteramos os testes antes de mudar o código?
A ideia por trás disso é passar um novo parâmetro ainda não implementado (que indica a razão da reprovação), verificar se os testes que antes passavam começaram a falhar e só então fazer a alteração do código no método situação(). Como o próprio slide descreve: "No TDD, mudança de requisito começa pelos testes. Eles são a especificação: primeiro passam a descrever a
regra nova, depois o código muda."

5. Qual ciclo foi o mais difícil para você, e por quê?
Como ainda não tenho muita familiaridade com a sintaxe do Java, a parte mais difícil foi escrever os testes de rejeição para os casos em que a nota da AI fosse maior que 30 ou menor que 0. Recorri a uma IA generativa, que me ajudou a elaborar esses testes usando a função anônima lambda.
# Tp2 DevOps

![CI Status](https://github.com/Cadu-Menezes/Tp2_Devops/actions/workflows/ci.yml/badge.svg)

## Etapa 5 - Provocando e Corrigindo Erro no Pipeline

Para exercitar a depuracao do pipeline, eu provoquei uma falha intencional alterando temporariamente um step do workflow para retornar erro (exit 1). Apos realizar o push, acompanhei a execucao na aba Actions do GitHub e identifiquei o job com falha.

Para diagnosticar a causa, utilizei:
- pagina da execucao (run) para localizar o job com erro;
- logs detalhados do step com X vermelho;
- secoes de annotations e summary para confirmar o ponto exato da falha.

Com a causa identificada, reverti a alteracao temporaria no workflow e fiz novo push. Na execucao seguinte, o pipeline concluiu com sucesso, confirmando que o problema foi corrigido.

## Etapa 6 - Monitoramento e Status do Pipeline

O badge no topo deste arquivo exibe em tempo real o status da ultima execucao do workflow principal (`CI - DevCalc`). Ele e gerado automaticamente pelo GitHub e atualiza conforme o resultado de cada run.

Ao comparar as execucoes realizadas, observei que o push automatico dispara o pipeline sem nenhuma intervencao humana, sendo ideal para verificacao continua a cada alteracao de codigo. Ja a execucao manual via `workflow_dispatch` oferece flexibilidade para acionar o pipeline quando necessario, sem precisar de um commit novo, e permite ainda customizar parametros de entrada como `run_tests` e `run_lint`, controlando quais jobs serao executados. Na aba Actions e possivel distinguir os dois modos pelo campo "Triggered by", que indica se o gatilho foi um push ou uma execucao manual, facilitando o monitoramento e a rastreabilidade das verificacoes realizadas.

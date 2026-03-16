# Explicacao: Workflows x Actions

Neste projeto, eu utilizei GitHub Actions para automatizar build, testes e analise de codigo. Abaixo explico os conceitos principais.

# 1) Diferenca entre workflow e action

- Workflow: e o fluxo de automacao completo. Ele define quando executar (`on`), em quais maquinas (`runs-on`), quais jobs e etapas (`steps`) serao executados.
- Action: e um bloco reutilizavel que executa uma tarefa especifica dentro de um step do workflow.

Em resumo:
- O workflow orquestra.
- A action executa uma tarefa encapsulada.

Exemplo pratico deste projeto:
- O workflow esta em [.github/workflows/ci.yml](.github/workflows/ci.yml).
- Dentro dele eu chamo actions como `actions/checkout@v4`, `actions/setup-java@v4` e `github/super-linter@v7`.

# 2) Como uma action e estruturada internamente

Uma action normalmente contem:
- Metadados (nome, descricao, entradas e saidas).
- Definicao de execucao (como rodar: JavaScript, Docker ou composite).
- Logica da tarefa (script, container ou comandos encadeados).

Tipos comuns:
- JavaScript action: executa codigo Node.js.
- Docker action: executa um container.
- Composite action: encadeia varios passos reutilizaveis.

# 3) Papel do arquivo action.yml

O `action.yml` (ou `action.yaml`) e o manifesto da action. Nele sao definidos:
- `inputs`: parametros de entrada da action.
- `outputs`: valores de saida para outros passos.
- `runs`: como a action sera executada e qual comando/entrypoint sera chamado.

Ou seja, o `action.yml` e o contrato publico da action: como usar, o que receber e o que devolver.

# 4) Exemplo real do projeto (Super Linter)

No workflow, eu chamei a action com `uses:`:

```yaml
- name: Executar Super Linter
  uses: github/super-linter@v7
  env:
    DEFAULT_BRANCH: main
    GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
    FILTER_REGEX_EXCLUDE: .*target/.*
    VALIDATE_JAVA: true
    VALIDATE_XML: true
    VALIDATE_YAML: true
```

Como funciona nesse exemplo:
- `uses: github/super-linter@v7` referencia a action no Marketplace e fixa a versao.
- Os parametros sao passados por `env` (variaveis de ambiente), como `VALIDATE_JAVA`, `VALIDATE_XML` e `VALIDATE_YAML`.
- O workflow controla quando esse step roda; a action executa internamente os linters configurados.

# 5) Conclusao

Eu entendo workflow como o roteiro da automacao e action como o componente reutilizavel que realiza tarefas especificas. No projeto, o workflow de CI orquestra os jobs e a action do Super Linter realiza a validacao de qualidade de codigo.
# Questao 1 - Banco Containerizado

# Arquivos
- Dockerfile baseado em postgres:17.8-alpine3.23
- data.sql copiado para /docker-entrypoint-initdb.d

# 1) Build da imagem

Comando:

docker build -t tp1-postgres:17.8 .

# 2) Preparacao de rede e volume

Comandos:

docker network create tp1-net
docker volume create tp1-pgdata

# 3) Subir container em modo detach (sem expor 5432)

Comando:

docker run -d --name tp1-postgres --network tp1-net -e POSTGRES_DB=rickmorty -e POSTGRES_USER=appuser -e POSTGRES_PASSWORD=appsecret -v tp1-pgdata:/var/lib/postgresql/data tp1-postgres:17.8

Observacao:
- Nenhum -p 5432:5432 foi usado.
- O banco fica acessivel apenas pela rede Docker.

# 4) Validar init na primeira execucao (logs)

Comando:

docker logs tp1-postgres

Evidencias esperadas no log (exemplos):
- /docker-entrypoint-initdb.d/01-data.sql
- CREATE TABLE
- INSERT 0 ...
- database system is ready to accept connections

# 5) Validar dados dentro do container

Listar tabelas:

docker exec -it tp1-postgres psql -U appuser -d rickmorty -c "\\dt"

Executar SELECT:

docker exec -it tp1-postgres psql -U appuser -d rickmorty -c "SELECT id, name, status FROM characters LIMIT 5;"

# 6) Comprovar que o init roda so na primeira execucao

Parar e remover somente o container (mantendo o volume):

docker stop tp1-postgres
docker rm tp1-postgres

Subir novamente com o mesmo volume:

docker run -d --name tp1-postgres --network tp1-net -e POSTGRES_DB=rickmorty -e POSTGRES_USER=appuser -e POSTGRES_PASSWORD=appsecret -v tp1-pgdata:/var/lib/postgresql/data tp1-postgres:17.8

Checar logs novamente:

docker logs tp1-postgres

Resultado esperado:
- Nao aparece reexecucao do script de init.
- Dados continuam presentes por causa do volume.

# 7) Limpeza opcional

docker stop tp1-postgres
docker rm tp1-postgres
docker volume rm tp1-pgdata
docker network rm tp1-net

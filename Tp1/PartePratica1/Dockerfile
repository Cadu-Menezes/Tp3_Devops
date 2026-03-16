FROM postgres:17.8-alpine3.23

# This script is executed only when the data directory is empty (first run).
COPY data.sql /docker-entrypoint-initdb.d/01-data.sql

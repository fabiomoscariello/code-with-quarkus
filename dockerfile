FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB myassicurazione
COPY insurance.sql /docker-entrypoint-initdb.d/
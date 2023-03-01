APP_IMAGE_LIST ?= authentication-service rabbitmq-producer-service rabbitmq-consumer-service department-service person-service kafka-consumer-service kafka-producer-service

start : down remove up

down :
	docker compose down

remove :
	docker image rm -f ${APP_IMAGE_LIST}

up:
	docker compose up -d

build:
	docker compose build

restart: down up

env:
	cp .env.example .env
	nano .env
up:
	docker-compose up -d
	./mvnw spring-boot:run

down:
	docker-compose down --remove-orphans

ps:
	docker-compose ps
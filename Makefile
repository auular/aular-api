start:
	docker-compose up -d
	mvn clean -e flyway:migrate -Dflyway.configFiles=flyway.conf
end:
	docker-compose down
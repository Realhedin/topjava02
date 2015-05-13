call mvn -P heroku,postgres -DskipTests=true package
call java -Dspring.profiles.active="datajpa,heroku" -DDATABASE_URL="postgres://user:user@localhost:5432/topjava02" -jar target/dependency/webapp-runner.jar target/*.war

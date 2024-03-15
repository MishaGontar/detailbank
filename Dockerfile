# Використовуємо базовий образ Java 17
FROM openjdk:17

# Встановлюємо робочу директорію
WORKDIR /app

# Додаємо JAR-файл додатка у контейнер
COPY target/detailbank-*.jar app.jar

# Встановлюємо команду для запуску додатка
CMD ["java", "-jar", "app.jar"]

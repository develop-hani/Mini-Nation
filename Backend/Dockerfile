FROM gradle:8.2.1-jdk11 as builder
WORKDIR /app

# 그래들 파일이 변경되었을 때만 새롭게 의존패키지 다운로드 받게함.
COPY ./Backend/build.gradle ./
COPY ./Backend/settings.gradle ./
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

# 빌더 이미지에서 애플리케이션 빌드
COPY ./Backend/ ./
RUN gradle build -x test --parallel

# APP
FROM azul/zulu-openjdk:11
WORKDIR /app

# 빌더 이미지에서 jar 파일만 복사
COPY --from=builder /app/build/libs/Backend-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

# root 대신 nobody 권한으로 실행
USER nobody
ENTRYPOINT [                                                \
    "java",                                                 \
    "-jar",                                                 \
    "-Djava.security.egd=file:/dev/./urandom",              \
    "-Dsun.net.inetaddr.ttl=0",                             \
    "Backend-0.0.1-SNAPSHOT.jar"              \
]

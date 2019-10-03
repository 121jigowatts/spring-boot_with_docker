# SPRING BOOT with Docker

Demo project for Spring Boot with Docker

## Gradleでビルド

`gradlew`スクリプトを実行することで`./build/libs/spring-boot_with_docker-0.0.1-SNAPSHOT.jar`が生成されます。ローカルでMongoDBを起動していないと接続エラーとなるため、テストはスキップしてビルドしています。

```
$ ./gradlew build -x test
```

## Dockerコンテナの生成／起動

`docker-compose`によりSpringBootアプリケーションサーバとMongoDBサーバを起動します。初回はDockerfileよりSpringBootアプリケーション用イメージを生成するため`--build`オプションを付与して実行します。

```
$ docker-compose up --build
```

### 動作確認

`curl`コマンドを実行するか、[http://localhost:8080/](http://localhost:8080/)にアクセスして「Welcome to SPRING BOOT with Docker.」のメッセージを確認します。

```
$ curl http://localhost:8080
```

## Dockerコンテナの停止

次のコマンドでコンテナを停止します。

```
$ docker-compose stop
```

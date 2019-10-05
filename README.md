# SPRING BOOT with Docker

Demo project for Spring Boot with Docker

## Gradleでビルド

SpringBootアプリケーション起動時にDB接続しているため、ローカルでMongoDBを起動しておきます。

```shell
docker run --name some-mongo -d -p 0.0.0.0:27017:27017 mongo:latest
```

`gradlew`スクリプトを実行することで`./build/libs/spring-boot_with_docker-0.0.1-SNAPSHOT.jar`が生成されます。

```shell
./gradlew build
```

この時にローカルでMongoDBが起動していない場合、テスト、ビルドに失敗します。テストをスキップしたい場合は`-x test`オプションを付与して実行します。

```shell
./gradlew build -x test
```

## Dockerコンテナの生成／起動

`docker-compose`によりSpringBootアプリケーションサーバとMongoDBサーバを起動します。初回はDockerfileよりSpringBootアプリケーション用イメージを生成するため`--build`オプションを付与して実行します。

```shell
docker-compose up --build
```

### 動作確認

`curl`コマンドを実行するか、[http://localhost:8080/](http://localhost:8080/)にアクセスして「Welcome to SPRING BOOT with Docker.」のメッセージを確認します。

```shell
curl http://localhost:8080
```

## Dockerコンテナの停止

次のコマンドでコンテナを停止します。

```shell
docker-compose stop
```

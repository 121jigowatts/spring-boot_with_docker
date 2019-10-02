# SPRING BOOT with Docker

Demo project for Spring Boot with Docker

## Gradleでビルド

`gradlew`スクリプトを実行することで`./build/libs/spring-boot_with_docker-0.0.1-SNAPSHOT.jar`が生成されます。

```
$ ./gradlew build
```

## Dockerイメージの作成

ビルドによって生成されたjarファイルを引数に指定します。`JAR_FILE`はDockerfileに定義されています。

```
$ docker build -t springboot-docker:0.0.1-SNAPSHOT ./ --build-arg JAR_FILE=./build/libs/spring-boot_with_docker-0.0.1-SNAPSHOT.jar
```

## Dockerコンテナの生成／起動

SpringBootアプリケーションはデフォルトで8080ポートで実行されますが、ホスト側のポートは3000にマッピングしています。また、コンテナ名は`springboot-app`としています。

```
$ docker run --name springboot-app -p 3000:8080 springboot-docker:0.0.1-SNAPSHOT
```

### 動作確認

`curl`コマンドを実行するか、[http://localhost:3000/](http://localhost:3000/)にアクセスして「Welcome to SPRING BOOT with Docker.」のメッセージを確認します。

```
$ curl localhost:3000
```

## Dockerコンテナの停止／起動

次のコマンドでコンテナ名を指定して停止します。

```
$ docker stop springboot-app
```

停止したコンテナを起動するには次のコマンドを実行します。

```
$ docker start springboot-app
```

***
いったん動いた状態でメモ

そのままだとDB接続エラーになるので、テストはスキップしてビルドしておく。
```
$ ./gradlew build -x test
```

初回実行時は`--build`オプションを付与して実行。
```
$ docker-compose up --build
```

止める時は次。
```
$ docker-compose stop
```
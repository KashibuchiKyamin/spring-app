# spring-app

## 概要

Spring Bootを用いたWebアプリケーションです。DDD（ドメイン駆動設計）を意識したパッケージ構成と、単方向依存の設計を目指しています。
印刷物の案件情報の閲覧アプリの体裁で作っています。

## 前提条件

- Java 21
- Gradle（ラッパー同梱）
- Docker（MySQL用、WSLのUbuntu上で動作推奨）
- 開発環境PCはWindows

## やりたいこと

- 通常のSpring Boot Webアプリケーションとして開発
- アプリ用データベースを利用し、他システムのAPIを呼び出して処理
- ログイン機能は後回し
- 一覧画面・詳細画面の作成
- 詳細画面の情報は他システムAPIから取得
- htmxと通常のAjaxの使い分け
- ロギングはビジネスロジックに含めない
- 全ソースに対してユニットテストを記述

## パッケージ構成

- `domain`：ビジネスロジック、エンティティ、値オブジェクト
- `infrastructure`：DBアクセス、外部API連携
- `presentation`：コントローラ、画面表示

## 起動方法

1. `./local-env/.env` にMySQLのパスワードとROOTのパスワードを空欄で記述しているので、編集する。
    - ROOTユーザのパスワードはDocker用。任意の値でOK。
    - 一般ユーザのパスワードは `.\src\main\resources\application.yaml` の値を転記する。
    - `.env`はコミットしないよう `$ git update-index --assume-unchanged .\local-env\.env` で除外
    - `.env`に設定すべき値が増えたら`$ git update-index --no-assume-unchanged .\local-env\.env` で戻す
2. WSLのUbuntu上でDockerを起動し、MySQL環境を構築する。
3. `./gradlew bootRun` でアプリケーションを起動する。

## テスト・設計チェック

- `.\gradlew.bat test` でユニットテスト・アーキテクチャルール（ArchUnit）を実行
- `.\gradlew.bat clean build jig` JIGによる依存関係を出力
  - JIGによる依存関係図は `build\jig\` 配下に出力

## 思想・設計方針

- DDDに基づくパッケージ分割
- 単方向依存をJIG・ArchUnitで可視化・検証
- Lombok不使用
- ロギングはビジネスロジックに含めない
- 外部APIのリクエスト/レスポンスのログはライブラリ利用
- htmxはHTMLへの細かいデータ設定用途、Ajaxはページネーションのあるテーブル表示用途
- MapperのテストはTestcontainer利用を検討したが、DockerはWSL上で使用し、アプリはWindows OS上で使用するため見送り

## 技術スタック

- Spring Boot
- MySQL（Docker）
- htmx
- ArchUnit（設計チェック）
- JIG（依存関係可視化）
- JUnit（テスト）

## その他

- 対象読者：チーム開発者向け

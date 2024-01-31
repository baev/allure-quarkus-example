## Allure Quarkus Example

[Allure Report](https://baev.github.io/allure-quarkus-example/)

By default, the runtime API (such as steps, attachments, labels, etc.) does not function correctly with Quarkus tests. This issue arises because Quarkus employs a separate class loader for tests, resulting in a distinct Allure Lifecycle instance being loaded for these tests.

To address this problem, you simply need to enable the loading of Allure classes from the Parent Class Loader. This can be accomplished by adding the following property to your `application.properties` file:

```properties
%test.quarkus.class-loading.parent-first-artifacts=io.qameta.allure:allure-java-commons

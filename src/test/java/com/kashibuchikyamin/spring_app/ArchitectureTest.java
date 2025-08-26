package com.kashibuchikyamin.spring_app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

/**
 * アーキテクチャルールを検証するArchUnitテストクラス
 * - Springのコンポーネントアノテーション（@Controller, @Service, @Repository, @Component）が付与されたクラスは、コンストラクタインジェクションのみを使用
 * - domainパッケージ配下のクラスは、infrastructureおよびpresentationパッケージに依存しない
 */
public class ArchitectureTest {
	/**
	 * Springのコンポーネントアノテーションが付与されたクラスは、フィールドがfinalのみ（コンストラクタインジェクション）であることを検証
	 */
	@DisplayName("Springコンポーネントはコンストラクタインジェクションのみ許可")
	@Test
	void componentClassesShouldUseConstructorInjection() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("com.kashibuchikyamin.spring_app");
		ArchRuleDefinition.classes()
			.that().areAnnotatedWith(org.springframework.stereotype.Component.class)
			.or().areAnnotatedWith(org.springframework.stereotype.Controller.class)
			.or().areAnnotatedWith(org.springframework.stereotype.Service.class)
			.or().areAnnotatedWith(org.springframework.stereotype.Repository.class)
			.should().haveOnlyFinalFields()
			.check(importedClasses);
	}

	/**
	 * domainパッケージ配下のクラスが、infrastructureおよびpresentationパッケージに依存しないことを検証
	 */
	@DisplayName("domainはinfrastructure・presentationに依存しない")
	@Test
	void domainShouldNotDependOnInfraOrPresentation() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("com.kashibuchikyamin.spring_app");
		ArchRuleDefinition.noClasses()
			.that().resideInAPackage("..domain..")
			.should().dependOnClassesThat()
			.resideInAnyPackage("..infrastructure..", "..presentation..")
			.check(importedClasses);
	}
}
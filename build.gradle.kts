import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id(Plugins.SpringBoot.name) 				version Plugins.SpringBoot.version
	id(Plugins.SpringDependencyManagement.name) version Plugins.SpringDependencyManagement.version 
	kotlin(Plugins.KotlinJvm.name) 				version Plugins.KotlinJvm.version
	kotlin(Plugins.KotlinPluginSpring.name) 	version Plugins.KotlinJvm.version 
	kotlin(Plugins.KotlinPluginJpa.name) 		version Plugins.KotlinJvm.version 
	kotlin(Plugins.Kapt.name)					version Plugins.Kapt.version 
	id(Plugins.KotlinNoArg.name)				version Plugins.KotlinNoArg.version 
	id(Plugins.KotlinAllOpen.name)				version Plugins.KotlinAllOpen.version 
}

buildscript {
	dependencies {
		classpath(Libs.SpringBoots.springBootGradlePlugin)
	}
}

group = "com.study"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {

	/** springboot **/
	implementation(Libs.SpringBoots.web)
	implementation(Libs.SpringBoots.security)
	implementation(Libs.SpringBoots.validation)
	implementation(Libs.SpringBoots.jacksonJsr)
	implementation(Libs.SpringBoots.jpa)
	implementation(Libs.SpringBoots.swagger)
	implementation(Libs.SpringBoots.swaggerData)
	implementation(Libs.SpringBoots.queryDsl)
	testImplementation(Libs.SpringBoots.test) {
		exclude(module = Libs.SpringBoots.Excludes.junit)
		exclude(module = Libs.SpringBoots.Excludes.mockitoCore)
	}

	/** test **/
	testImplementation(Libs.Test.kotestRunner)
	testImplementation(Libs.Test.kotestAssertion)
	testImplementation(Libs.Test.kotestExtension)
	testImplementation(Libs.Test.kotestStringExtension)
	testImplementation(Libs.Test.mockk)
	testImplementation(Libs.Database.h2)
	/** kotlin **/
	implementation(Libs.Kotlin.jacksonModule)
	implementation(Libs.Kotlin.reflect)
	implementation(Libs.Kotlin.stdlibJdk8)
	implementation(Libs.Kotlin.logging)
	kapt(Libs.SpringBoots.configuration)
	/** db **/
	implementation(Libs.Database.h2)
	kapt(Libs.Kapt.queryDsl)
	if(project.hasProperty(Profiles.profile)) {
		if(project.property(Profiles.profile).toString() == Profiles.local) {
			implementation(Libs.SpringBoots.p6spy)
		}
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = Environments.KotlinOption.freeCompilerArgs
		jvmTarget = Environments.KotlinOption.jvmTarget
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

noArg {
	annotation(Annotation.entity)
//	annotation(Annotation.mappedSuperclass)
//	annotation(Annotation.embeddable)
}

allOpen {
	annotation(Annotation.entity)
	annotation(Annotation.mappedSuperclass)
	annotation(Annotation.embeddable)
}
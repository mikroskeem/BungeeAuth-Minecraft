plugins {
    java
    id("net.minecrell.licenser") version "0.3"
    id("net.minecrell.plugin-yml.bungee") version "0.2.1"
}

val gradleWrapperVersion: String by extra
val waterfallApiVersion: String by extra

repositories {
    mavenLocal()
    mavenCentral()

    maven {
        name = "oss-sonatype"
        setUrl("https://oss.sonatype.org/content/groups/public/")
    }

    maven {
        name = "destroystokyo-repo"
        setUrl("https://repo.destroystokyo.com/repository/maven-public/")
    }
}


dependencies {
    compileOnly("io.github.waterfallmc:waterfall-api:$waterfallApiVersion")
}

license {
    header = rootProject.file("etc/HEADER-mikroskeem")
    filter.include("**/eu/mikroskeem/**/*.kt")
    filter.include("**/eu/mikroskeem/**/*.java")
}

bungee {
    name = "BungeeAuth"
    main = "me.vik1395.BungeeAuth.Main"
    description = "A player authentication plugin."
    author = "${listOf("Vik1395", "mikroskeem")}"
}

val wrapper by tasks.creating(Wrapper::class) {
    gradleVersion = gradleWrapperVersion
    distributionUrl = "https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip"
}

defaultTasks("licenseFormat", "build")
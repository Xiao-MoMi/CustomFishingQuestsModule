plugins {
    id("java")
}

group = "net.momirealms"
version = "1.2"

repositories {
    mavenCentral()
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://maven.enginehub.org/repo/")
    maven("https://jitpack.io/")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("dev.folia:folia-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("me.pikamug.quests:quests-api:5.0.1")
    compileOnly("me.pikamug.quests:quests-core:5.0.1")
    compileOnly("com.github.PikaMug:LocaleLib:3.6")
    compileOnly("com.github.Xiao-MoMi:Custom-Fishing:2.0.2")
}
plugins {
    id("java")
}

group = "net.momirealms"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://maven.enginehub.org/repo/")
    maven("https://jitpack.io/")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("dev.folia:folia-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("me.blackvein.quests:quests-api:4.8.3")
    compileOnly("me.blackvein.quests:quests-core:4.8.3")
    compileOnly("com.github.PikaMug:LocaleLib:3.6")
    compileOnly("com.github.Xiao-MoMi:Custom-Fishing:2.0-beta-6")
}
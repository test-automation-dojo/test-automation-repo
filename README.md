# test-automation-repo

## Development Environment Setup

### Setup browser for automation

You could either setup Firefox manually or use Dockerized environment instead. The latter is recommended if you have a Mac or Windows 10 dev machine.

#### Firefox
- Download and install compatible version: FF 46.0
- Downgrade if needed: https://ftp.mozilla.org/pub/firefox/releases/46.0/
- Switch off auto upgrade for this version for the time of the dojo 
  (Switching off internet may be required, if the auto upgrade is too quick)

#### Docker based Firefox and Selenium server

TODO. 

### IDE

You could use either IntelliJ IDEA or Eclipse for development IDE. The former is recommended.

#### IntelliJ IDEA (recommended)
- Download and install [IntelliJ IDEA Community](https://www.jetbrains.com/idea/#chooseYourEdition)
- Open
- Select project root directory
- Dependencies should be installed automatically
- Run -> Run Main

#### Eclipse
- Download and install [Eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/neon3rc3)
- Install [Buildship Gradle Integration](http://marketplace.eclipse.org/content/buildship-gradle-integration) from the Eclipse Marketplace
- File -> Import -> Gradle -> Existing Gradle Project
- Select project root directory
- Finish
- Dependencies should be installed automatically
- Run -> Run As -> JUnit Test

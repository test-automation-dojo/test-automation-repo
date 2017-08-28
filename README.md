# test-automation-repo

## Development Environment Setup

### Setup browser for automation

You could either setup Firefox manually or use Dockerized environment instead. The latter is recommended if you have a Mac or Windows 10 dev machine.

#### Local Firefox
- Download and install compatible version: FF 46.0
- Downgrade if needed: https://ftp.mozilla.org/pub/firefox/releases/46.0/
- Switch off auto upgrade for this version for the time of the dojo 
  (Switching off internet may be required, if the auto upgrade is too quick)

#### Docker container based testing environment (Recommended)

This setup has the ability to switch browser and browser versions freely and easily. Also has the potential to scale out.

- Install [Docker](https://www.docker.com/) on your computer. For local development & testing you should select "Get Docker -> For Desktops".
- Test your docker installation by running `docker run hello-world` in your terminal. If all good, you should see "Hello from Docker!".
- Spin up the Docker container by running `docker run -d -p 4444:4444 -p 5900:5900 --name docker-selenium-firefox selenium/standalone-firefox-debug` . The container is based on an image which has `Selenium Server`, `Firefox` and `VNC server` installed.
- Run `docker ps`, you should be able to see `Up XXX time` in the new container's Status.

### Setup Development IDE

You could use either IntelliJ IDEA or Eclipse for development IDE. The former is recommended.

#### IntelliJ IDEA (Recommended)
- Download and install [IntelliJ IDEA Community](https://www.jetbrains.com/idea/#chooseYourEdition)
- Open
- Select project root directory
- Dependencies should be installed automatically
- Run -> Run Main
- If you're using Docker based environment, you should be able to connect to VNC server on `vnc://127.0.0.1:5900` and see the tests running. VNC password is `secret`.

#### Eclipse
- Download and install [Eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/neon3rc3)
- Install [Buildship Gradle Integration](http://marketplace.eclipse.org/content/buildship-gradle-integration) from the Eclipse Marketplace
- File -> Import -> Gradle -> Existing Gradle Project
- Select project root directory
- Finish
- Dependencies should be installed automatically
- Run -> Run As -> JUnit Test
- If you're using Docker based environment, you should be able to connect to VNC server on `vnc://127.0.0.1:5900` and see the tests running. VNC password is `secret`.

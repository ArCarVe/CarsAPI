<h1 align="center"> ArCarVe API </h1> <br>

<p align="center">
  An API responsible for handling car related operations.
</p>


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Testing](#testing)
- [API](#requirements)
- [Acknowledgements](#acknowledgements)




## Introduction

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This API was developed with Spring Boot and PostgreSQL as a studying project.

## Features
TODO: Description of features

* Include a list of
* all the many beautiful
* web server features


## Requirements
It is recommended to run the application in a docker container, the requirements for each setup are listed below.


### Docker
* [Docker](https://www.docker.com/get-docker)


## Quick Start
Make sure the JWT Verification Key URL is configured, then you can run the server in a docker container or on your local machine.

### Configure JWT Verification Key
Update __application.yml__. Set `auth.jwt.publicKeyUrl` to the URL to fetch the JWT verification key. The application will not start if it can't set the verification key for the JWTConverter.

The default value in the __application.yml__ file is set to connect to EGO running locally on its default port `8081`.

### Run Local
```bash
$ mvn spring-boot:run
```

Application will run by default on port `1234`

Configure the port by changing `server.port` in __application.yml__


### Run Docker

First build the image:
```bash
$ docker-compose build
```

When ready, run it:
```bash
$ docker-compose up
```

Application will run by default on port `8080`

Configure the port by changing `services.api.ports` in __docker-compose.yml__.


## API
TODO: API Reference with examples, or a link to a wiki or other documentation source.

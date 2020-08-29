#!/bin/bash
set -v
mvn clean
#mvn test -DscanURL="https://java2blog.com/"
mvn test -DscanURL=$1

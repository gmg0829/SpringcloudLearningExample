#!/usr/bin/env bash
set -eo pipefail
modules=( discovery server client zuul )
for module in "${modules[@]}"; do
    docker build -t "microservice/${module}:latest" ${module}
done

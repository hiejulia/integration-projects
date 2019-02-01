#!/usr/bin/env bash



docker build --file=Dockerfile \
  --tag=demo-backend:latest --rm=true .
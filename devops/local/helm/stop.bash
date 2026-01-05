#!/bin/bash
helm template local-helm | podman kube down -
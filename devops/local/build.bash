#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/../.." && pwd)"

IMAGE_NAME="$(basename "$PROJECT_ROOT")"

podman build \
  -f "$PROJECT_ROOT/Dockerfile-local" \
  "$PROJECT_ROOT" \
  -t "$IMAGE_NAME"

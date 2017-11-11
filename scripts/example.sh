#!/bin/bash

DIR=$(dirname $0)
CMD="$DIR/rewrite-tests.sh"
CLASS="de.topobyte.Test"

exec "$CMD" "$CLASS" "$@"

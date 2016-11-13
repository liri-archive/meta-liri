#!/bin/sh
#
# This file is part of Liri.
#
# Copyright (C) 2016 The Qt Company Ltd.
# Copyright (C) 2016 Pier Luigi Fiorini <pierluigi.fiorini@gmail.com>
#
# $BEGIN_LICENSE:GPL3KDE+$
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version approved by the KDE Free Qt
# Foundation.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.
#
# $END_LICENSE$
#

while test -n "$1"; do
  case "$1" in
    "--help" | "-h")
      echo "Usage: . $0 [build directory]"
      return 0
      ;;
    *)
      BUILDDIRECTORY=$1
    ;;
  esac
  shift
done

THIS_SCRIPT="setup-environment.sh"
if [ "$(basename -- $0)" = "${THIS_SCRIPT}" ]; then
    echo "Error: This script needs to be sourced. Please run as '. $0'"
    exit 1
fi

if [ -z "$MACHINE" ]; then
    echo "Error: MACHINE environment variable not defined"
    return 1
fi

BUILDDIRECTORY=${BUILDDIRECTORY:-build-${MACHINE}}

if [ ! -f ${PWD}/${BUILDDIRECTORY}/conf/bblayers.conf ]; then
  case ${MACHINE} in
    intel-corei7-64)
      LAYERSCONF="bblayers.conf.intel.sample"
    ;;
    *)
      LAYERSCONF="bblayers.conf.sample"
      echo "Unknown MACHINE, bblayers.conf might need manual editing"
    ;;
  esac

  mkdir -p ${PWD}/${BUILDDIRECTORY}/conf
  cp ${PWD}/sources/meta-liri/conf/${LAYERSCONF} ${PWD}/${BUILDDIRECTORY}/conf/bblayers.conf
fi

export TEMPLATECONF="${PWD}/sources/meta-liri/conf"
. sources/poky/oe-init-build-env ${BUILDDIRECTORY}

unset BUILDDIRECTORY
unset TEMPLATECONF
unset LAYERSCONF

#!/bin/bash
#
# This file is part of Liri.
#
# Copyright (C) 2017 Pier Luigi Fiorini <pierluigi.fiorini@gmail.com>
#
# $BEGIN_LICENSE:GPL3+$
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
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

if [ -z "$1" ]; then
    echo "Usage: $0 [machine]"
    exit 1
fi

build_dir=build-$1

if [ ! -d "$build_dir" ]; then
    echo "No such directory $build_dir"
    exit 1
fi

echo "-------------------------------------" >> build.log
export MACHINE=${build_dir#*-}
. ./setup-environment.sh

echo "${MACHINE}:" >> ../build.log
echo "  start: $(date)" >> ../build.log
bitbake -c clean lirios-image
bitbake lirios-image
if [ $? -ne 0 ]; then
    echo "    build failed" >> ../build.log
fi
echo "  end:   $(date)" >> ../build.log

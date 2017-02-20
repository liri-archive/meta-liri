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
    echo "Usage: $0 [machine] [<argument 1>, <argument N>, ..."
    exit 1
fi

build_dir=build-$1
shift

if [ ! -d $build_dir ]; then
    echo "Build directory \"$build_dir\" not found"
    exit 1
fi

export MACHINE=${build_dir#*-}
. ./setup-environment.sh $build_dir

exec bitbake $*

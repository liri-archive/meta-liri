#!/bin/bash
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

echo "-------------------------------------" >> build.log
for DIR in $(ls -d build-*); do
    (
    export MACHINE=${DIR#*-}
    . ./setup-environment.sh

    echo "${MACHINE}:" >> ../build.log
    echo "  start: $(date)" >> ../build.log
    bitbake lirios-image meta-toolchain-b2qt-embedded-sdk
    if [ $? -ne 0 ]; then
        echo "    build failed" >> ../build.log
    fi
    echo "  end:   $(date)" >> ../build.log
    )
done

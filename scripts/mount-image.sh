#!/bin/sh
#
# This file is part of Liri.
#
# Copyright (C) 2016 The Qt Company Ltd.
# Copyright (C) 2017 Pier Luigi Fiorini <pierluigi.fiorini@gmail.com>
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

set -e

if [ $# -ne 1 ]; then
    echo "Usage: $0 <image>"
    echo "Mount the two partitions (boot and rootfs) from the image to current folder"
    exit 1
fi

IMAGE=$1

if [ ! -f "${IMAGE}" ]; then
    echo "Image '${IMAGE}' not found"
    exit 1
fi

mkdir -p boot
mkdir -p root

sudo umount boot root || true

OFFSET=$(sudo parted "${IMAGE}" unit B print | grep "^ 1" | awk {'print $2'} | cut -d B -f 1)
sudo mount -o loop,offset=${OFFSET} "${IMAGE}" boot

OFFSET=$(sudo parted "${IMAGE}" unit B print | grep "^ 2" | awk {'print $2'} | cut -d B -f 1)
sudo mount -o loop,offset=${OFFSET} "${IMAGE}" root

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

DESCRIPTION = "Additional tools packagegroup for Liri OS image"
LICENSE = "LICENSE.GPLv3"

PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = " \
    adbd \
    alsa-utils-amixer \
    binutils \
    binutils-symlinks \
    htop \
    i2c-tools \
    iproute2 \
    ldd \
    ntp \
    openssh-sftp-server \
    perf \
    rsync \
    tslib-calibrate \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "systemd-analyze", "", d)} \
    networkmanager-adsl \
    networkmanager-openvpn \
    networkmanager-nmtui \
"

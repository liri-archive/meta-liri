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

DESCRIPTION = "Packagegroup for Liri OS image"
LICENSE = "LICENSE.GPLv3"

PR = "r0"

inherit packagegroup

MACHINE_EXTRA_INSTALL ?= ""

RDEPENDS_${PN} = " \
    alsa-plugins \
    kernel-modules \
    linux-firmware \
    ca-certificates \
    coreutils \
    dconf \
    liberation-fonts \
    ttf-devanagari \
    ttf-opensans \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    otf-noto \
    tzdata \
    tzdata-americas \
    tzdata-asia \
    tzdata-europe \
    ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "weston weston-examples", "", d)} \
    networkmanager \
    liri-world \
    lirios-customization \
    ${MACHINE_EXTRA_INSTALL} \
"

#
# This file is part of Liri.
#
# Copyright (C) 2016 Pier Luigi Fiorini <pierluigi.fiorini@gmail.com>
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

DESCRIPTION = "Liri OS"
LICENSE = "LICENSE.GPLv3"
PR = "r0"

DEPLOY_CONF_TYPE = "LiriOS"

IMAGE_FEATURES += " \
    package-management \
    ssh-server-openssh \
    tools-debug \
    debug-tweaks \
    hwcodecs \
"

inherit core-image consistent_timestamps

IMAGE_INSTALL += " \
    packagegroup-lirios-base \
    packagegroup-lirios-tools \
    ${@bb.utils.contains("DISTRO_FEATURES", "gstreamer010", "packagegroup-b2qt-embedded-gstreamer010", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "gstreamer", "packagegroup-b2qt-embedded-gstreamer", "", d)} \
    packagegroup-qt5 \
"

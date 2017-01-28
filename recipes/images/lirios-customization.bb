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

DESCRIPTION = "Custom settings for Liri OS image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r0"

inherit allarch

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_PN += " \
    networkmanager \
"

pkg_postinst_${PN} () {
#!/bin/sh
# Replace networkd with NetworkManager
rm -f $D/lib/systemd/system/multi-user.target.wants/systemd-networkd.service
rm -f $D/lib/systemd/system/sockets.target.wants/systemd-networkd.socket
ln -s /usr/lib/systemd/system/NetworkManager.service $D/lib/systemd/system/multi-user.target.wants/NetworkManager.service
}

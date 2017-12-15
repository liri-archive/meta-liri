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

DESCRIPTION = "Qt5 modules"
LICENSE = "LICENSE.GPLv3"

inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS_${PN} += " \
    qt3d \
    qtbase \
    qtcanvas3d \
    qtcharts \
    qtconnectivity \
    qtdatavis3d \
    qtdeclarative \
    qtdeclarative-tools \
    qtgraphicaleffects \
    qtimageformats \
    qtlocation \
    qtmultimedia \
    qtnetworkauth \
    qtquickcontrols \
    qtquickcontrols2 \
    qtscxml \
    qtsensors \
    qtserialbus \
    qtserialport \
    qtsvg \
    qttools \
    qttranslations-qt \
    qttranslations-qtbase \
    qttranslations-qtdeclarative \
    qttranslations-qtconnectivity \
    qttranslations-qtlocation \
    qttranslations-qtmultimedia \
    qttranslations-qtquickcontrols \
    qttranslations-qtserialport \
    qttranslations-qtwebsockets \
    qttranslations-qtxmlpatterns \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'webengine', 'qtwebengine qttranslations-qtwebengine', '', d)} \
    qtwebsockets \
    qtwebchannel \
    qtxmlpatterns \
    qtvirtualkeyboard \
    "

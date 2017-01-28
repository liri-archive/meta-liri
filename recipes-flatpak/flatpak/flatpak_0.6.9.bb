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

DESCRIPTION = "Application deployment framework for desktop apps"
HOMEPAGE = "http://flatpak.org"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit autotools pkgconfig gettext systemd

SRC_URI = "https://github.com/flatpak/${BPN}/releases/download/${PV}/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "3214f00d4d44a4515a05145c791adac334f37ade2e58318ddcceb944085a3330"

EXTRA_OECONF += " \
    --disable-docbook-docs \
    --disable-gtk-doc-html \
    --disable-documentation \
    --disable-system-helper \
    --disable-seccomp \
    --disable-xauth \
    --with-systemdsystemunitdir=${systemd_unitdir}/system \
"

PACKAGES =+ " \
    ${PN}-build \
    ${PN}-bash-completion \
    ${PN}-gdm \
"

DEPENDS = " \
    glib-2.0 \
    json-glib \
    libsoup-2.4 \
    libarchive \
    elfutils \
    fuse \
    ostree \
    libassuan \
    libgpg-error \
    bubblewrap \
    systemd \
    gobject-introspection \
"

RDEPENDS_${PN} = "bubblewrap"

FILES_${PN} += " \
    ${libdir}/systemd/user/*.service \
    ${libdir}/systemd/user/dbus.service.d/*.conf \
    ${libdir}/girepository-1.0 \
    ${datadir}/gir-1.0 \
    ${datadir}/dbus-1/services/*.service \
    ${datadir}/dbus-1/interfaces/*.xml \
"

FILES_${PN}-build = "${bindir}/flatpak-builder"

FILES_${PN}-bash-completion = " \
    ${sysconfdir}/profile.d/flatpak.sh \
    ${datadir}/bash-completion/completions/flatpak \
"

FILES_${PN}-gdm = " \
    ${datadir}/gdm/env.d/flatpak.env \
"

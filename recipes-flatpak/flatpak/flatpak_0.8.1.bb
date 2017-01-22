DESCRIPTION = "Versioned Application/Runtime Respository."
HOMEPAGE = "http://flatpak.org"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit autotools pkgconfig gettext systemd

SRC_URI = "https://github.com/flatpak/${BPN}/releases/download/${PV}/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "9de103312b86f1033fa12768dc836525d6d9385defc80306e68691df66e7edaf"

PACKAGES =+ " \
    ${PN}-build \
    ${PN}-bash-completion \
    ${PN}-gdm \
"

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

AUTO_LIBNAME_PKGS = ""

# possible package configurations
PACKAGECONFIG ??= ""

DEPENDS = " \
    glib-2.0 json-glib libsoup-2.4 libarchive elfutils fuse \
    ostree libassuan libgpg-error bubblewrap systemd \
    gobject-introspection \
"

RDEPENDS_${PN} = "bubblewrap"

EXTRA_OECONF += " \
    --disable-docbook-docs \
    --disable-gtk-doc-html \
    --disable-documentation \
    --disable-system-helper \
    --disable-seccomp \
    --disable-xauth \
    --with-systemdsystemunitdir=${systemd_unitdir}/system \
"

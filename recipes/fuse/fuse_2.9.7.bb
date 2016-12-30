DESCRIPTION = "Filesystem in Userspace."
HOMEPAGE = "http://fuse.sf.net"
LICENSE = "LGPLv2.1|GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

inherit autotools pkgconfig

PV = "2.9.7"

SRC_URI = "https://github.com/libfuse/libfuse/releases/download/fuse-${PV}/fuse-${PV}.tar.gz"

PACKAGES += "${PN}-devices"

FILES_${PN}-devices = "/dev/fuse"

AUTO_LIBNAME_PKGS = ""

# possible package configurations
PACKAGECONFIG ??= ""
FUSE_MOUNT_PATH = "${@bb.utils.contains('DISTRO_FEATURES', 'usrmerge', \
                   '/usr/sbin', '/sbin', d)}"

do_configure_prepend() {
    export MOUNT_FUSE_PATH="${FUSE_MOUNT_PATH}"
}

EXTRA_OECONF_class-target += " \
    --enable-lib \
    --enable-util \
    --disable-example \
    --disable-mtab \
"

EXTRA_OECONF_class-native += " \
    --enable-lib \
    --enable-util \
    --disable-example \
    --disable-mtab \
"

BBCLASSEXTEND = "native"

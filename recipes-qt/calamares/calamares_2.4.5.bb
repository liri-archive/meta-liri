SUMMARY = "Distribution-independent installer framework"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=d32239bcb673463ab874e80d47fae504 \
"

inherit kde-base pkgconfig

DEPENDS += " \
    qttools \
    qtsvg \
    qtwebengine \
    kconfig \
    kcoreaddons \
    ki18n \
    solid \
    yaml-cpp \
    udisks2 \
    polkit-qt5 \
    kpmcore \
    kparts \
    python \
    boost \
"

SRC_URI = "https://github.com/${BPN}/${BPN}/releases/download/v${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "ec4805b7322748d13d869e7f3e1b42f7"
SRC_URI[sha1sum] = "ece125baeb35dfd61b404187c6e0e89d7af051ec"

FILES_${PN} += " \
    ${datadir}/calamares \
"

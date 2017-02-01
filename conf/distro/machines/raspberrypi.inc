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

IMAGE_FSTYPES += "ext3 rpi-sdimg"

QBSP_IMAGE_CONTENT ?= "\
    ${IMAGE_LINK_NAME}.img \
    ${IMAGE_LINK_NAME}.conf \
"

MACHINE_EXTRA_INSTALL += "\
    omxplayer \
"

KERNEL_MODULE_AUTOLOAD += "snd-bcm2835 bcm2835-v4l2"
KERNEL_MODULE_PROBECONF += "bcm2835-v4l2"
module_conf_bcm2835-v4l2 = "options bcm2835-v4l2 gst_v4l2src_is_broken=1"

# Video camera support
VIDEO_CAMERA = "1"

MACHINE_FEATURES += "pitft"

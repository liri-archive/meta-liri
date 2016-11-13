FROM ubuntu:14.04
MAINTAINER Pier Luigi Fiorini <pierluigi.fiorini@gmail.com>
RUN apt-get update && apt-get -y upgrade && \
    apt-get install -y build-essential chrpath curl diffstat gcc-multilib gawk git-core libsdl1.2-dev texinfo unzip wget xterm && \
    apt-get install -y bzip2 dosfstools mtools parted syslinux tree
RUN useradd -m -u 1000 builduser && passwd -d builduser
USER builduser

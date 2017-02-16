FROM ubuntu:14.04
MAINTAINER Pier Luigi Fiorini <pierluigi.fiorini@gmail.com>
RUN apt-get update && apt-get -y upgrade && \
    apt-get install -y build-essential chrpath curl diffstat gcc-multilib gawk git-core libsdl1.2-dev texinfo unzip wget xterm && \
    apt-get install -y bzip2 dosfstools mtools parted syslinux tree fakeroot
RUN useradd -m -u 1000 builduser && passwd -d builduser
RUN locale-gen en_US.UTF-8  
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en' LC_ALL='en_US.UTF-8'
USER builduser

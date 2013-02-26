require ti-xdctools.inc

PV = "3_16_02_32"
LIC_FILES_CHKSUM = "file://docs/license/xdc/shelf/package.html;md5=4a6bd0c8258d3ce1172b56f5f9946b17"

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"

SRC_URI[xdcbin.md5sum] = "110803859243385090520fc119cb27c3"
SRC_URI[xdcbin.sha256sum] = "0a3db1d117a1a459d32e7b4feae032a36abc4243fcbbedb0a02d8cfed1767f28"

S = "${WORKDIR}/ti/xdctools_${PV}"

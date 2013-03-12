# Use the version of u-boot.inc in oe-core not the meta-ti version
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot bootloader for DaVinci devices"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

COMPATIBLE_MACHINE = "da830-omapl137-evm"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r0"

SRC_URI = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git;branch=${BRANCH}"

SRC_URI += "file://0001-da830_wifi_evm-add-an-entry-in-boards.cfg-for-da830-.patch"

BRANCH = "master"

# Use literal tags in SRCREV, when available, instead of commit IDs
SRCREV = "DEV_DAVINCIPSP_03.22.00.02"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "bin"

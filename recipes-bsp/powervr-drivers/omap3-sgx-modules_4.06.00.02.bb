DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ea5743acf520dd81ca172e69f818a3d4"

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../../recipes-ti/includes/ti-eula-unpack.inc

SGXPV = "4_06_00_02"
IMGPV = "1.7.867897"
BINFILE := "Graphics_SDK_setuplinux_${SGXPV}.bin"

inherit module

MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

# Not making this the default version to match a similar setting
# in the matching libgles-omap3_4.06.00.02 recipe.
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/${BINFILE}"
SRC_URI[md5sum] = "62f0c378e38f8d14e9f184c3836aea21"
SRC_URI[sha256sum] = "71c8e154484304b3ce32d565557720a96c7ba762e72d7f1e93deeef9f3274402"
TI_BIN_UNPK_WDEXT="/Graphics_SDK_${SGXPV}"
S = "${WORKDIR}${TI_BIN_UNPK_WDEXT}/GFX_Linux_KM"

PVRBUILD = "release"
export KERNELDIR = "${STAGING_KERNEL_DIR}"

INHIBIT_PACKAGE_STRIP = "1"

TI_PLATFORM_omap3 = "omap3630"
TI_PLATFORM_ti814x = "ti81xx"
TI_PLATFORM_ti816x = "ti81xx"
TI_PLATFORM_ti33x = "ti335x"

MODULESLOCATION_omap3 = "dc_omapfb3_linux"
MODULESLOCATION_ti814x = "dc_ti81xx_linux"
MODULESLOCATION_ti816x = "dc_ti81xx_linux"
MODULESLOCATION_ti33x = "dc_ti335x_linux"

export SUPPORT_XORG ?= "${@base_contains('DISTRO_FEATURES', 'x11', '1', '0', d)}"

MAKE_TARGETS = " BUILD=${PVRBUILD} TI_PLATFORM=${TI_PLATFORM} SUPPORT_XORG=${SUPPORT_XORG}"

do_install() {
    mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
    cp  ${S}/pvrsrvkm.ko \
        ${S}/services4/3rdparty/${MODULESLOCATION}/omaplfb.ko  \
        ${S}/services4/3rdparty/bufferclass_ti/bufferclass_ti.ko \
        ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr

	if [ "${SUPPORT_XORG}" = "1" ]; then
	    cp ${S}/services4/3rdparty/linux_drm/drm.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	fi
}

SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI33x devices from PSP"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "ti33x"

DEFAULT_PREFERENCE = "-1"

inherit kernel

# Stage the power management firmware before building the kernel
DEPENDS += "am33x-cm3"

KERNEL_IMAGETYPE = "uImage"

# The main PR is now using MACHINE_KERNEL_PR, for ti33x see conf/machine/include/ti33x.inc
MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"

BRANCH = "v3.2-staging"

# This SRCREV corresponds to tag v3.2_AM335xPSP_04.06.00.08
SRCREV = "d7e124e8074cccf9958290e773c88a4b2b36412b"

SRC_URI = "git://arago-project.org/git/projects/linux-am33x.git;protocol=git;branch=${BRANCH} \
           file://defconfig \
           ${KERNEL_PATCHES} \
"

S = "${WORKDIR}/git"

# Allow a layer to easily add to the list of patches or completely override them.
KERNEL_PATCHES ?= "${PATCHES}"

# Add a set of patches that enabled features, fixed bugs or disabled buggy features
# that weren't part of the official PSP release
PATCHES = "file://0001-musb-update-PIO-mode-help-information-in-Kconfig.patch \
               file://0001-am335x_evm_defconfig-turn-off-MUSB-DMA.patch \
               file://0001-mach-omap2-pm33xx-Disable-VT-switch.patch"

# Add Cryptography support early driver patches while working to get the driver
# upstream.
PATCHES += "file://0001-am33x-Add-memory-addresses-for-crypto-modules.patch \
                file://0002-am33x-Add-crypto-device-and-resource-structures.patch \
                file://0003-am33x-Add-crypto-device-and-resource-structure-for-T.patch \
                file://0004-am33x-Add-crypto-drivers-to-Kconfig-and-Makefiles.patch \
                file://0005-am33x-Create-header-file-for-OMAP4-crypto-modules.patch \
                file://0006-am33x-Create-driver-for-TRNG-crypto-module.patch \
                file://0007-am33x-Create-driver-for-AES-crypto-module.patch \
                file://0008-am33x-Create-driver-for-SHA-MD5-crypto-module.patch \
                file://0002-AM335x-OCF-Driver-for-Linux-3.patch \
                file://0001-am335x-Add-crypto-driver-settings-to-defconfig.patch \
                file://0001-am335x-Add-pm_runtime-API-to-crypto-driver.patch \
                file://0002-am335x-Add-suspend-resume-routines-to-crypto-driver.patch \
               "

# Add SmartReflex support early driver patches while working to get the driver
# upstream.
PATCHES += "file://0001-am33xx-Add-SmartReflex-support.patch \
                file://0002-am33xx-Enable-CONFIG_AM33XX_SMARTREFLEX.patch \
               "

# Add a patch to the omap-serial driver to allow suspend/resume during
# Bluetooth traffic
PATCHES += "file://0001-omap-serial-add-delay-before-suspending.patch"

# Add patch to allow wireless to work properly on EVM-SK 1.2.
PATCHES += "file://0001-am3358-sk-modified-WLAN-enable-and-irq-to-match-boar.patch"

# Add CPU utilization patch for WLAN
PATCHES += "file://0001-am335xevm-using-edge-triggered-interrupts-for-WLAN.patch"

# Add patch to enable pullup on WLAN enable
PATCHES += "file://0001-am335x-enable-pullup-on-the-WLAN-enable-pin-fo.patch"

# Copy the am33x-cm3 firmware if it is available
do_compile_prepend() {
    if [ -e "${STAGING_DIR_HOST}/${base_libdir}/firmware/am335x-pm-firmware.bin" ]
    then
        cp "${STAGING_DIR_HOST}/${base_libdir}/firmware/am335x-pm-firmware.bin" "${S}/firmware"
    fi
}

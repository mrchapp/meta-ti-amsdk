SECTION = "kernel"
DESCRIPTION = "Linux kernel for DaVinci EVM from PSP, based on linux-davinci kernel"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

require tipspkernel.inc
inherit kernel

MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""

BRANCH = "da830"
SRCREV = "DEV_DAVINCIPSP_03.22.00.02"

COMPATIBLE_MACHINE = "(omapl137)"

SRC_URI += "git://arago-project.org/git/projects/linux-davinci.git;protocol=git;branch=${BRANCH} \
    file://defconfig"

SRC_URI += " \
    file://0001-Input-TouchScreen-Introduce-TSC2004-driver-support.patch \
    file://0002-davinci-da830-omap-l137-evm-add-support-for-tsc2004-.patch \
    file://0003-davinci-Add-platform-data-for-da830-omap-l137-char-l.patch \
    file://0004-da830-omap-l137-Configure-LCD-priority-to-highest.patch \
    file://0005-da830-omap-l137-Configure-LCD_AC_ENB_CS-pin-as-LCD-f.patch \
    file://0006-da830-fix-build-error-caused-by-the-lcdc-platform-ch.patch \
    file://0007-da8xx-omap-l1-Add-default-configuration-for-DA830.patch \
    file://0008-da830-wifi-evm-Adds-support-for-da830-wifi-evm-in-Kc.patch \
    file://0009-da830-wifi-evm-Add-support-for-da830-wifi-evm.patch \
    file://0010-da830-wifi-evm-audio-Changes-audio-codec-name.patch \
    file://0011-da830_omapl137-add-new-wl18xx-switch-to-kconfig.patch \
    file://0012-da830-wifi-evm-add-wl18xx-support-for-da830-wifi-evm.patch \
    file://0013-da830-wifi-evm-add-default-defconfig-for-da830-wifi-.patch \
    file://0014-da830_omapl137_defconfig-activate-wlan-related-switc.patch \
    file://0015-wl12xx-allow-selecting-WL12XX_PLATFROM_DATA-independ.patch \
    file://0016-da830-evm-add-wl18xx-platform-support.patch \
    file://0017-da830-wifi-evm-Corrects-WIFI-Nand-and-SPI-UART0-rela.patch \
    file://0018-da830-wifi-evm-reset-tx-and-rx-of-UART0.patch \
    file://0019-board-da830-evm-disable-high-speed-mode-for-SD-inter.patch \
    file://0020-video-da8xx-fb-update-LCD-driver-to-support-VGA-mode.patch \
    file://0021-da830-EVM-Add-LCD-platform-support-for-VGA-mode.patch \
    file://0022-da830-wifi-evm-Set-the-BT_EN-corresponding-gpio-to-h.patch \
    file://0023-da830-select-da830-config-as-default.patch \
    "

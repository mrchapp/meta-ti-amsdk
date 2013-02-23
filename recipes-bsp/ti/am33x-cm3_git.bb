DESCRIPTION = "Cortex-M3 binary blob for suspend-resume"

LICENSE = "TI-BSD"
LIC_FILES_CHKSUM = "file://License.txt;md5=858099c817e47ea63559fc6b67ae8d91"

COMPATIBLE_MACHINE = "ti33x"

PV = "04.06.00.10-rc1"
PR = "r0"

SRC_URI = "git://arago-project.org/git/projects/am33x-cm3.git"

#This SRCREV corresponds to tag AM335xPSP_04.06.00.10-rc1
SRCREV = "27ca4643e422245a95723de1df0247a00eada45b"

S = "${WORKDIR}/git"

do_compile() {
	make CC="${TARGET_CC}" CROSS_COMPILE="${TARGET_PREFIX}"
}

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 bin/am335x-pm-firmware.bin ${D}${base_libdir}/firmware/
}

FILES_${PN} = "${base_libdir}/firmware"

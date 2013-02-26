DESCRIPTION = "TI EDMA3 Low Level Driver (LLD)"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/${SRC_URI_edma3lldsite}/edma3_lld"
SECTION = "devel"
LICENSE = "TI"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc

S = "${WORKDIR}/edma3_lld_${PV}"

SRC_URI = "http://t3500wsk1.am.dhcp.ti.com/~x0019444/da830-evm/edma3_lld_${PV}.tar.gz;name=edma3lldtarball"

do_install() {
    install -d ${D}${EDMA3_LLD_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${EDMA3_LLD_INSTALL_DIR_RECIPE}
}

